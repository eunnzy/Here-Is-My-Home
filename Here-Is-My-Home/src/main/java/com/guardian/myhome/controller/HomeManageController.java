package com.guardian.myhome.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.guardian.myhome.service.HomeService;
import com.guardian.myhome.vo.HomeImgVO;
import com.guardian.myhome.vo.HomeVO;
import com.guardian.myhome.vo.HomeImgUploadVO;
import com.guardian.myhome.vo.HomeOptionVO;

import net.coobird.thumbnailator.Thumbnailator;

/*
 	집(매물) 관리 관련 컨트롤러 
 	- 등록, 수정, 상태 변경 등 
 */

@Controller
@RequestMapping("/home/manage")
public class HomeManageController {
	@Autowired
	HomeService homeService;
	
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String registerForm() {
		return "home/manage/registerHome";
	}
	
	// 집(매물) 등록
/*	@RequestMapping(value = "/register", method = RequestMethod.POST)
	@ResponseBody
	public int registerHome(@RequestBody HashMap<String, Object> home) {
		HomeVO homeVO = new HomeVO();
		 // OptionVO optionVO = new OptionVO();
		
		System.out.println(home);
		
		HashMap<String, Object> resultMap = new HashMap<>();
		
		for(String key: home.keySet()) { 	// view에서 가져온 키 값들을 돌면서 체크
			System.out.println(key + " : " + home.get(key));
			if(!(home.get(key).equals(""))) {	// 공백이 아닌 것( 데이터를 갖고 있는 것)
				switch(key) {
					case "homeType": homeVO.setHomeType((String)home.get(key)); break;
					case "addr1" : homeVO.setAddr1((String)home.get(key)); break;
					case "addr2" : homeVO.setAddr2((String)home.get(key)); break;
					case "addr3" : homeVO.setAddr1((String)home.get(key)); break;
					case "homeArea" : homeVO.setHomeArea((int)home.get(key)); break;
					case "tradingType" : homeVO.setTradingType((String)home.get(key)); break;
					case "deposit": homeVO.setDeposit((int)home.get(key)); break;
					case "monthly": homeVO.setMonthly((int)home.get(key)); break;
					case "rentPeriods": homeVO.setRentPeriods((int)home.get(key)); break;
					case "roomCount" : homeVO.setRoomCount((int)home.get(key)); break;
					case "adminCost": homeVO.setAdminCost((int)home.get(key)); break;
					case "parking": homeVO.setParking((int)home.get(key)); break;
					case "pet": homeVO.setPet((String)home.get(key)); break;
					case "elevator": homeVO.setElevator((String)home.get(key)); break;
					case "balcony": homeVO.setBalcony((String)home.get(key)); break;
					case "moveDate": homeVO.setMoveDate((Date)home.get(key)); break;
					case "floor": homeVO.setFloor((int)home.get(key)); break;
					case "optionList":
						break;
					case "homeTitle": homeVO.setHomeTitle((String)home.get(key)); break;
					case "homeDetail": homeVO.setHomeDetail((String)home.get(key)); break;
					
				}
			}
			
		}
		
		return 1;
	}*/
	
	// 매물 등록 
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String registerHome(HomeVO homeVO, HttpServletRequest request, HttpServletResponse response) {
		System.out.println(homeVO.toString());
		
		System.out.println("OptionVO -- ");
		if(homeVO.getOptionList() != null) {
			homeVO.getOptionList().forEach(
					option -> System.out.println("" + option));
		}
		
		System.out.println("\nHomeImgVO--");
 		if (homeVO.getHomeImgList() != null) {
			homeVO.getHomeImgList().forEach(
					attach -> System.out.println("" + attach));
        }
		
		
//		List<ImgUploadVO> imgList;
//		
//		// 파일 유형이 이미지 파일인지 확인
//		for(MultipartFile multifile : homeImg) {
//			File fileCheck = new File(multifile.getOriginalFilename());
//			String type = null;
//			
//			try {
//				type = Files.probeContentType(fileCheck.toPath());		
//				System.out.println("Type : " + type);
//			}catch(IOException e) {
//				e.printStackTrace();
//			}
//			
//			if(!type.startsWith("image")) {
//				imgList = null;
//			}
//		}
//		
//		String uploadPath = "C:\\homeUpload";	// 파일 저장 경로
//		List<HomeImgVO> homeImgList = new ArrayList<>();
//		
//		for(MultipartFile multifile : homeImg) {
//
//			HomeImgVO homeImgVO = new HomeImgVO();
//			
//			String imgName = multifile.getOriginalFilename();	// 파일 이름
//			String uuid = UUID.randomUUID().toString();	// 사진 파일 이름이 중복 되면 덮어 쓰기 때문에 이를 방지 하기 위한 UUID(식별자)를 적용.
//			imgName = uuid + "_" + imgName;	// ex) uuid_fileName.jpg/png
//
//			File save = new File(uploadPath, imgName);		
//			System.out.println("파일 이름 : " + imgName);		
//			System.out.println("파일 타입 : " + multifile.getContentType());
//			System.out.println("파일 크기 : " + multifile.getSize());	
//			
//			try {
//				multifile.transferTo(save); // transferTo() : 업로드 되는 파일(save) 파일 저장 
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//			
//			homeImgVO.setHomeNum(homeNum);
//			homeImgVO.setHomeImgName(imgName);
//			homeImgVO.setHomeImgPath(uploadPath);
//			
//			homeImgList.add(homeImgVO);
//		}
		
 		homeService.insertHome(homeVO);
 		
		return "home/manage/complete";
	}
	
			
	@RequestMapping(value = "/homeImgUpload", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<List<HomeImgVO>> uploadImage(@RequestParam MultipartFile[] homeImg, HttpServletRequest request, 
							HttpServletResponse response) {
		
		// 파일 유형이 이미지 파일인지 확인
		for(MultipartFile multifile : homeImg) {
			File fileCheck = new File(multifile.getOriginalFilename());
			String type = null;
			
			try {
				type = Files.probeContentType(fileCheck.toPath());		
			}catch(IOException e) {
				e.printStackTrace();
			}
			
			if(!type.startsWith("image")) {
				List<HomeImgVO> list = null;
				return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);
			}

		}
		
		String uploadPath = "C:\\homeUpload";	// 파일 저장 경로
		String homeImgPath = "homeImg";
		File uploadFolder = new File(uploadPath, homeImgPath);
		
		if(!uploadFolder.exists())	// 위 경로가 존재하지 않으면
			uploadFolder.mkdirs();
		
		List<HomeImgVO> homeImgList = new ArrayList<>();	// 매물 이미지 담는 ArrayList 객체
		
		for(MultipartFile multifile : homeImg) {
			
			HomeImgVO homeImgVO = new HomeImgVO();	// 매물 이미지 정보 객체 생성
			
			String imgName = multifile.getOriginalFilename();	// 파일 이름
			String uuid = UUID.randomUUID().toString();	// 사진 파일 이름이 중복 되면 덮어 쓰기 때문에 이를 방지 하기 위한 UUID(식별자)를 적용.
			imgName = uuid + "_" + imgName;	// ex) uuid_fileName.jpg/png

			// 매물 객체 정보 저장	
			homeImgVO.setHomeImgName(imgName);	
			homeImgVO.setHomeImgPath(homeImgPath);	
			
			File save = new File(uploadFolder, imgName);		
			System.out.println("파일 이름 : " + imgName);		
			System.out.println("파일 타입 : " + multifile.getContentType());
			System.out.println("파일 크기 : " + multifile.getSize());
			
			try {
				multifile.transferTo(save); // 파일 저장 

				// 썸네일 이미지 저장 
				FileOutputStream thumbnail = new FileOutputStream(new File(uploadFolder, "t_" + imgName));
				Thumbnailator.createThumbnail(multifile.getInputStream(), thumbnail, 100, 100);
				thumbnail.close();
				
				homeImgList.add(homeImgVO);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			ResponseEntity<List<HomeImgVO>> result = new ResponseEntity<List<HomeImgVO>>(homeImgList, HttpStatus.OK);
			return result;
		}
		return null;
	}
	
	@RequestMapping(value = "/showHomeImg", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getHomeImg(String homeImgName) {
		System.out.println(homeImgName);
		File imgFile = new File("C:\\homeUpload", homeImgName);
		
		ResponseEntity<byte[]> result = null;
		
		try {
			HttpHeaders header = new HttpHeaders();
			header.add("Content-type", Files.probeContentType(imgFile.toPath()));
		
			result = new ResponseEntity<>(FileCopyUtils.copyToByteArray(imgFile), header, HttpStatus.OK);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	// 매물 사진 삭제
	@RequestMapping(value = "/removeHomeImg" , method = RequestMethod.POST)	// 매물 사진 삭제
	public ResponseEntity<String> deleteHomeImg(String homeImgName) {
		File file = null;
		
		System.out.println("deleteHome:" +homeImgName);
		try {
			// 썸네일 파일 삭제
			file = new File("C:\\homeUpload\\"+ URLDecoder.decode(homeImgName, "UTF-8"));
			file.delete();
			
			// 원본 파일 삭제
			String originImgName = file.getAbsolutePath().replace("t_", "");	// 썸네일 파일 "t_" 붙은 것을 ""로
			System.out.println(originImgName);
			
			file = new File(originImgName);
			file.delete();
		
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("fail", HttpStatus.NOT_IMPLEMENTED);
		}
		
		return new ResponseEntity<String>("success", HttpStatus.OK);	// 성공했다고 리턴.
	}
}
