<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>매물 등록</title>
	<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
	<link href="/css/bootstrap.min.css" rel="stylesheet"></link>
	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR&display=swap" rel="stylesheet">
	<link href="/css/registerHome.css"  type="text/css" rel="stylesheet" >
	<style>
		.home-container {
			margin-top: 30px;
			padding: 30px;
			height:auto;
			border-radius: 10px;
			background-color: white;
		}
		.addBtn{
			margin: auto;
			display: block;
			padding: 15px 40px;
			font-size: 20px;
			border: none;
			cursor:pointer;
			background-color: #BEE9FB;
		}
		table {
			border: 1px solid #8c8c8c;
		}
		
		thead {
			border-bottom: 1px solid #8c8c8c;
		}
		.img-select div{
		  display: inline-block;
		  border: 1px solid #ddd;
		  width: 250px;
		  height: 250px;
		  z-index: 1;
		}
		.img-select div input[type=file]{
		  display: none;
		}
		.img-select div label{
		  display: inline-block;
		  width: 250px;
		  height: 250px;
		  background: url("/img/photo.png") no-repeat center;
		  z-index: 0;
		}
		.img-select div label:hover{
		  background: url("/img/photo.png") #CCE1FF no-repeat center;
		}
		.img-div img{
		max-width: 100%;
	    height: auto;
	    display: block;
	    padding: 5px;
	    margin-top: 10px;
	    margin: auto;	
		}
		.img-div {
			position: relative;
		}
		.imgDelete{
		    position: absolute;
		    top: 0;
		    right: 5%;
		    background-color: #ef7d7d;
		    color: wheat;
		    font-weight: 900;
		    width: 30px;
		    height: 30px;
		    border-radius: 50%;
		    line-height: 26px;
		    text-align: center;
		    border: none;
		    display: block;
		    cursor: pointer;	
		}
	
	/*  
		photo 이미지 출처 : 
		https://www.flaticon.com/free-icon/picture_2659360?term=photo&page=1&position=8&origin=tag&related_id=2659360 
	*/		
    </style>
</head>
<body>
	<header>
		<jsp:include page="../../header.jsp"></jsp:include>
	</header>
	
	<div class="home-container col-md-9 mx-auto">
		<h1 class="mt-3 mb-3"> 방 올리기 </h1>
		<div class="add-notice p-3 mx-auto mb-5" >
        	<ul>
        		<li>전/월세 매물만 등록할 수 있습니다.</li>
        		<li>매물 등록시 바로 거래가 가능합니다. </li>
        		<li>허위 매물 등록시 웹 사이트 이용에 제한이 있을 수 있습니다. 이 점을 주의하여 사실 정보만을 기입하길 바랍니다.</li>
        	</ul>
       	</div>
       	<div class="form-div">
       		<form id="homeForm" method="post">
       			<table class="table mb-5">
                    <thead>
                        <tr>
                            <th colspan="2" > <h3 class="text-center"> 매물 종류 </h3> </th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td> 방 종류  </td>
                            <td class="radio-btn"> 
                            	<div class="form-check form-check-inline">
                                	<input type="radio" class="form-check-input" name="homeType" value="원룸"> <label> 원룸 </label> 
                                </div>
                                <div class="form-check form-check-inline">
                                	<input type="radio" class="form-check-input" name="homeType" value="투룸"> <label> 투룸 </label> 
                                </div>
                                <div class="form-check form-check-inline">
                                	<input type="radio" class="form-check-input" name="homeType" value="쓰리룸 이상"> <label> 쓰리룸 이상 </label> 
                                </div>
                                <div class="form-check form-check-inline">
                                	<input type="radio" class="form-check-input" name="homeType" value="오피스텔"> <label> 오피스텔 </label> 
                                </div>
                                <div class="form-check form-check-inline">
                                	<input type="radio" class="form-check-input" name="homeType" value="아파트"> <label> 아파트 </label> 
                                </div>
                                <div class="form-check form-check-inline">
                                	<input type="radio" class="form-check-input" name="homeType" value="쉐어하우스"> <label> 쉐어하우스 </label> 
                            	</div>
                            </td>
                        </tr>
                    </tbody>
               	</table>
               	
               	<table class="table mb-5">
                    <thead>
	                    <tr>
                            <th colspan="2"> <h3 class="text-center"> 위치 정보 </h3> </th>
                        </tr>
                   	</thead>
                   	<tbody>
                        <tr>
                            <td> 주소  </td>
                            <td> 
                            	 <div class="row mb-3">
								    <label for="addr1" class="col-sm-2">우편번호</label>
								    <div class="col-sm-5">
								   		<input type="text" class="form-control" name="addr1" id="addr1">
							    	</div>
							    	<div class="col-sm-4">
							    		<button type="button" class="btn btn-primary" id="searchPost"> 주소 검색</button> 
							    	</div>
							    </div>
							    <div class="row mb-3">
								    <label for="addr2" class="col-sm-2">주소</label>
								    <div class="col-sm-10">
								   		<input type="text" class="form-control" name="addr2" id="addr2" >
							    	</div>
							    </div>
							     <div class="row mb-3">
								    <label for="addr3" class="col-sm-2">상세정보</label>
								    <div class="col-sm-10">
								   		<input type="text" class="form-control" name="addr3" id="addr3">  
							    	</div>
							    </div>
                            </td>
                        </tr>
                  		</tbody>
               </table>
                    
               <table class="table mb-5">
            	<thead>	
                  		<tr>
                           <th colspan="2"> <h3 class="text-center"> 매물 정보 </h3> </th>
                       </tr>
                   </thead>
                   <tbody>
                       <tr>
                           <td> 크기  </td>
                           <td> 
                           	<div class="row">
								<div class="col-sm-auto">
									<label for="homeArea">전용 면적:</label>
								</div>                            	
							    <div class="col-sm-auto">
							   		<input class="form-control" type="text" name="homeArea">
						    	</div>
						    	<div class="col-sm-auto">
							   		<label>평</label>
						    	</div>
						    </div>
                           </td>
                       </tr>
                       <tr>
                           <td> 거래 종류  </td>
                           <td>
                               <input type="radio" class="form-check-input" name="tradingType" value="월세"> <label> 월세 </label> 
                               <input type="radio" class="form-check-input" name="tradingType" value="전세"> <label> 전세 </label> 
                           </td>
                       </tr>
                       <tr>
                           <td> 보증금  </td>
                           <td>
                           	<div class="row mb-3">
							    <div class="col-auto">
							   		 <input class="form-control" type="text" name="deposit">
						    	</div>
						    	<div class="col-auto">
							   		<label>만원</label>
						    	</div>
						    </div>
                           </td>
                       </tr>
                       <tr>
                           <td> 월세  </td>
                           <td>
	                           	<div class="row mb-3">
								    <div class="col-auto">
								   		<input class="form-control" type="text" name="monthly">
							    	</div>
						    		<div class="col-auto">
							   			<label>만원</label>
							   		</div>
							   		<div class="col-auto">
							   			<label>*전세인 경우 0으로 작성</label>
							   		</div>
						    		</div>
						   	 	</div>
                           </td>
                       </tr>
                       <tr>
                           <td> 임대 기간  </td>
                           <td>    
                           		<div class="row mb-3">
								    <div class="col-auto">
								   		<input class="form-control" type="text" name="rentPeriods">
							    	</div>
						    		<div class="col-auto">
							   			<label>년</label>
							   		</div>
						   	 	</div>
                           </td>
                       </tr>
                       <tr>
                           <td> 방 개수  </td>
                           <td>    
                        		<div class="row mb-3">
								    <div class="col-auto">
								   		<input class="form-control" type="text" name="roomCount">
							    	</div>
						    		<div class="col-auto">
							   			<label>개</label>
							   		</div>
							   	</div>
                           </td>
                       </tr>
                   </tbody>
               </table>
               
               <table class="table mb-5">
                   <thead>
                       <tr>
                           <th colspan="2"> <h3 class="text-center"> 추가 정보 </h3> </th>
                       </tr>
                   </thead>
                   <tbody>
                       <tr>
                           <td> 관리비  </td>
                           <td> 
                           		<div class="row mb-3">
								    <div class="col-auto">
								   		<input class="form-control" type="text" name="adminCost">
							    	</div>
						    		<div class="col-auto">
							   			<label>만원</label>  
						    		</div>
						   	 	</div>
                           </td>
                       </tr>
                       <tr>
                           <td> 주차  </td>
                           <td>
                           		<div class="row mb-3">
								    <div class="col-auto">
								   		<input class="form-control" type="text" name="parking">
							    	</div>
						    		<div class="col-auto">
							   			<label>대</label> 
						    		</div>
						   	 	</div>
                           </td>
                       </tr>
                       <tr>
                           <td> 반려동물  </td>
                           <td class="radio-btn">
                               <input class="form-check-input" type="radio" name="pet" value="가능"> <label> 가능 </label> 
                               <input class="form-check-input" type="radio" name="pet" value="불가능"> <label> 불가능 </label> 
                           </td>
                       </tr>
                       <tr>
                           <td> 엘리베이터  </td>
                           <td class="radio-btn">
                               <input class="form-check-input" type="radio" name="elevator" value="가능"> <label> 가능 </label> 
                               <input class="form-check-input" type="radio" name="elevator" value="불가능"> <label> 불가능 </label> 
                           </td>
                       </tr>
                       <tr>
                           <td> 베란다 / 발코니  </td>
                           <td class="radio-btn">    
                               <input class="form-check-input" type="radio" name="balcony" value="가능"> <label> 가능 </label> 
                               <input class="form-check-input" type="radio" name="balcony" value="불가능"> <label> 불가능 </label> 
                           </td>
                       </tr>
                       <tr>
                           <td> 입주 가능 일  </td>
                           <td>    
                           		<div class="col-3">
                               		<input class="form-control" type="date" name="moveDate"> 
                               </div>
                           </td>
                       </tr>
                       <tr>
                           <td> 층  </td>
                           <td>
                           		<div class="row mb-3">
									<div class="col-auto">
										<label> 해당 층: </label> 
									</div>                            	
							    <div class="col-auto">
							   		 <input class="form-control" type="text" name="floor">
						    	</div>
						    	<div class="col-auto">
							   		<label> * 지하인 경우 '-' 붙여서 기입 ex) -1 </label>
						    	</div>
						    </div>
                              	
                           </td>
                       </tr>
                       <tr>
                           <td>옵션 </td>
                           <td>
                           		<div class="form-check form-check-inline">
                                	<input type="checkbox" class="form-check-input" autocomplete="off" name="optionList" value="세탁기">
								 	<label class="form-check-label">세탁기</label>
                                </div>
                                <div class="form-check form-check-inline">
                                	<input type="checkbox" class="form-check-input"  autocomplete="off" name="optionList" value="TV">
								 	<label class="form-check-label">TV</label>
                                </div>
                                <div class="form-check form-check-inline">
                                	<input type="checkbox" class="form-check-input" autocomplete="off" name="optionList" value="전자레인지">
								 	<label class="form-check-label" >전자레인지 </label>
                                </div>
                                <div class="form-check form-check-inline">
                                	<input type="checkbox" class="form-check-input" autocomplete="off" name="optionList" value="인덕션">
								 	<label class="form-check-label" >인덕션</label>
                                </div>
                                <div class="form-check form-check-inline">
                                	<input type="checkbox" class="form-check-input" autocomplete="off" name="optionList" value="책상">
								 	<label class="form-check-label" >책상 </label>
                                </div>
                                <div class="form-check form-check-inline">
                                	<input type="checkbox" class="form-check-input" autocomplete="off" name="optionList" value="침대">
								 	<label class="form-check-label" >침대 </label>
                                </div>
                                <div class="form-check form-check-inline">
                                	<input type="checkbox" class="form-check-input" autocomplete="off" name="optionList" value="에어컨">
								 	<label class="form-check-label">에어컨 </label>
                                </div>
							 	<div class="form-check form-check-inline">
                                	<input type="checkbox" class="form-check-input"autocomplete="off" name="optionList" value="냉장고">
								 	<label class="form-check-label">냉장고 </label>
                                </div>
                                <div class="form-check form-check-inline">
                                	<input type="checkbox" class="form-check-input" autocomplete="off" name="optionList" value="신발장">
								 	<label class="form-check-label">신발장 </label>
                                </div>
							 	<div class="form-check form-check-inline">
                                	<input type="checkbox" class="form-check-input" autocomplete="off" name="optionList" value="옷장">
								 	<label class="form-check-label">옷장 </label>
                                </div>
                                <div class="form-check form-check-inline">
                                	<input type="checkbox" class="form-check-input"autocomplete="off" name="optionList" value="도어락">
								 	<label class="form-check-label" >도어락 </label>
                                </div>
                                <div class="form-check form-check-inline">
                                	<input type="checkbox" class="form-check-input"  autocomplete="off" name="optionList" value="비데">
								 	<label  class="form-check-label">비데</label>
                                </div>
                           </td>
                       </tr>
                   </tbody>
               </table>
               
                <table class="table mb-5">
                   <thead>
                       <tr>
                           <th colspan="2" class="text-center"> <h3> 상세 정보 </h3> </th>
                       </tr>
                   </thead>
                   <tbody >
                       <tr>
                           <td> 제목  </td>
                           <td> 
                               <input class="form-control" type="text" name="homeTitle" >           
                           </td>
                       </tr>
                       <tr>
                           <td> 상세 설명  </td>
                           <td><textarea class="form-control"  name="homeDetail" rows="10"></textarea>
                           </td>
                       </tr>
                   </tbody>
               </table>
                <table class="table mb-5">
                   <thead>
                       <tr>
                           <th colspan="2"> <h3 class="text-center"> 사진 등록 </h3> </th>
                       </tr>
                   </thead>
                   <tbody>
	            	<tr>
		                <td>
		                	<div class="add-notice p-3 mx-auto mb-3">
					        	<ul>
					        		<li> 사진은 최소 2장 이상 등록해야 합니다.</li>
					        		<li> 최대 10장까지 올릴 수 있습니다.</li>
					        	</ul>
					       	</div>
				       		<input type="file" name="homeImg" id="homeImg" multiple="multiple">
					       	<div class="resultImg">
						       	 <!-- <div class="img-div">
						       		<div class="imgDelete">X</div>
						       		<img src="/home/showHomeImg?homeImgName=homeImg/oneroom.jpg">
						       	</div> -->
					       	</div>
					       	<!-- <div class="img-div">
							    <div class="img-add">
							        <div class="img-input-div0">
							            <label for ="img_plus_0"></label>
							            <input type="file" name="homeImg" id="homeImg" multiple="multiple">
							        </div>
							    </div>
							</div> -->
							<!-- <div class="image">
							    <div class="img-select">
							        <div class="img-div0">
							            <label for="img-add0"></label>
							            <input type="file" id="img-add0" name="homeImg" multiple="multiple">
							        </div>
							    </div>
							</div>  -->
		                </td>
             		</tr>
            		</tbody>
				</table>
       		</div>
       		<div class="text-center mx-auto">
        		<button type="reset" class="btn btn-large mr-2">취소</button>
 				<button type="submit" id="addBtn" class="btn btn-large" >등록</button>
			</div>
    	</form>	
	</div>

	<script src="/js/registerHome.js" ></script>
	<!-- 우편 번호 검색 -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script>
	$("#searchPost").click(function() {
		new daum.Postcode({
		    oncomplete: function(data) {
   			// 위치 검색 api
            	 var addr = '';
	                var extraAddr = ''; 
	 
	                if (data.userSelectedType === 'R') { 
	                    addr = data.roadAddress;
	                } else { 
	                    addr = data.jibunAddress;
	                }
	 
	                if(data.userSelectedType === 'R'){
	                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                        extraAddr += data.bname;
	                    }
	                    if(data.buildingName !== '' && data.apartment === 'Y'){
	                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                    }
	                    if(extraAddr !== ''){
	                        extraAddr = ' (' + extraAddr + ')';
	                    }
	                	addr += extraAddr;
	                } else {
	                	addr += ' ';
	                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('addr1').value = data.zonecode;
                document.getElementById('addr2').value = addr;
                document.getElementById('addr3').focus();
            }
        }).open();	 
	});
   </script>
</body>
</html>