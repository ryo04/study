/**
 * 書籍一覧画面
 */
$(function() {
	// テーブルの行をクリックしたときの処理
	$('#bookList tbody tr').on('click', function() {
		// すべての行の選択状態を解除
		$('#bookList tbody tr').removeClass('table-row-active');
		// クリックされた行に選択状態のクラスを追加
		$(this).addClass('table-row-active');
		// 更新ボタン、削除ボタンを活性化
		$('#editBtn').removeAttr('disabled');
		$('#deleteDummyBtn').removeAttr('disabled');
		
		// 書籍ID一時保管
		editSelectedBookId($(this));
	});
	
	$('#deleteOkBtn').click(function() {
		$('#deleteBtn').trigger('click');
	});
});

/**
 * テーブルで選択された行の書籍IDを画面のhidden要素に保管します。
 * 
 * @param row 選択された行情報
 */
function editSelectedBookId(row) {
	row.find('td').each(function() {
		var columnId = $(this).attr('id');
		if (columnId.startsWith('bookId_')) {
			$('#selectedBookId').val($(this).text());
			return false;
		}
	});
}