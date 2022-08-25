function findSentence(sentence) {
  document.getElementById("key").innerHTML = "Tìm câu chứa từ: ";
  document.getElementById("input").innerHTML = sentence;
  let word = prompt("Nhập từ cần tìm: ");
  let result;

  if (word) {
    let copy = nonAccentVietnamese(sentence);
    console.log(copy);
    if (copy[copy.length - 1] != ".") {
      copy = copy + ".";
    }
    let copyword = nonAccentVietnamese(word);
    console.log(copyword);
    let pattern = new RegExp("\\b[\\s\\w]*\\b" + copyword + "\\b[\\s\\w]*\\b[.]");
    result = copy.match(pattern);
    let list = getOriginalSentence(sentence);
    for (let i = 0; i < list.length; i++) {
      if (nonAccentVietnamese(list[i]) == result) {
        result = list[i];
      }
    }
  

    document.getElementById("descript").innerHTML =
      "Câu đầu tiên chứa từ: " + word;
    document.getElementById("result").innerHTML = result;
  }
}

function nonAccentVietnamese(str) {
  str = str.toLowerCase();
  str = str.replaceAll(/à|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ/g, "a");
  str = str.replaceAll(/è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ/g, "e");
  str = str.replaceAll(/ì|í|ị|ỉ|ĩ/g, "i");
  str = str.replaceAll(/ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ/g, "o");
  str = str.replaceAll(/ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ/g, "u");
  str = str.replaceAll(/ỳ|ý|ỵ|ỷ|ỹ/g, "y");
  str = str.replaceAll(/đ/g, "d");
  str = str.replaceAll(/\u0300|\u0301|\u0303|\u0309|\u0323/g, "");
  str = str.replaceAll(/\u02C6|\u0306|\u031B/g, "");
  // str = str.replaceAll(/,|:/g, "");
  str = str.replaceAll(/\?|!|;|:/g, ".");
  str = str.replaceAll(/[^\w.\s]/g, "");

  // str = str.replaceAll(/[\s]?[^\w.][\s]?/g, " ");
  

  return str;
}

let sen =
  "Những suy đOán xung quanh TƯƠNG lai của cầu THỦ 37 tuổi và những " +
  "lời chỉ trích Anh phải nhận đã liên tục NỔ ra trong vài tuần gần " +
  "đây. Nhưng Neville tin rằng vấn đề lớn nhất của Man United là hàng " +
  "phòng ngự kém và thiếu nhất quán của họ: “Hàng thủ Manchester United " +
  "không tốt lắm, tôi phải nói thẳng; Họ quá mâu thuẫn và không đáng tin " +
  "cậy! Bạn không thể thực sự tin tưởng họ? BạN không biết điều gì sẽ xảy ra khi hỌ chơi quá lỏng lẻo";

function getOriginalSentence(paragragh) {
  let str = paragragh.replaceAll(/\?|!|;|:/g, ".");
  let list = str.split(".");
  for (let i = 0; i < list.length; i++) {
    list[i] = list[i].trim() + ".";
    console.log(list[i]);
  }
  return list;
}
getOriginalSentence(sen);

findSentence(sen);
