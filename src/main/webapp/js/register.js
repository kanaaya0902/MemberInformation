// 職業選択時に「その他」が選ばれた場合の処理
function checkOccupation(select) {
    var otherOccupation = document.getElementById("otherOccupation");
    // 「その他」が選ばれた場合、テキストボックスを表示して必須に設定
    if (select.value === "other") {
        otherOccupation.classList.remove("hidden");
        otherOccupation.required = true;
    } else {
        // それ以外の場合、テキストボックスを非表示にして必須を解除
        otherOccupation.classList.add("hidden");
        otherOccupation.required = false;
    }
}
