$(document).ready(function() {
	var operForm = $("#operForm");
	
	$("#modifyBT").on("click", function(e) {
		e.preventDefault();
		operForm.attr("action", "/community/modify");
		operForm.submit();
	});
	
	$("#deleteBT").on("click", function(e) {
		e.preventDefault();
		operForm.attr("action", "/community/delete.do");
		operForm.submit();
	});
	
	$("#BackBT").on("click", function(e) {
		e.preventDefault();
		operForm.find("#bno").remove();
		operForm.attr("action", "/community/list");
		operForm.submit();
	});
});