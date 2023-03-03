$("#reservModalBtn").click(function() {
	$(".reserv-modal").css("display", "flex");
})

$(".reserv-close").click(function() {
	$(".reserv-modal").css("display", "none");
})
	

$("#reservBtn").on("click", function(e){
	console.log($('#enrollDate').val());
	$.ajax({
				url: 'reservation/enroll', 
				data: { 
				lessorId: lessorId,
				imchaId : $('#enrollName').val(),
				homeNum : homeNum,
				revDate : enrollDate + ' ' + revTime
				}, 
				type: 'POST',
				success: function (param) { 
				alert('예약이 완료되었습니다.');
				},
				error: function () {
				alert('네트워크 오류 발생');
				}
	});  
});