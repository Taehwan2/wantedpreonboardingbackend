# wantedpreonboardingbackend

## 프로젝트 
### 개요


### 배경

## 개발인원(Member)
|장태환|BE 팀원| 백앤드 개발|


## 프로젝트 기술 스택
### Environments
<img src="https://img.shields.io/badge/intellij-000000?style=for-the-badge&logo=intellijidea&logoColor=white"><img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white"><img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white">

### Development Stack
#### BackEnd

<img src="https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"><img src="https://img.shields.io/badge/springsecurity-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white"><img src="https://img.shields.io/badge/ubuntu-E95420?style=for-the-badge&logo=ubuntu&logoColor=white"><img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white">



## 요구사항

1. **채용공고를 등록합니다.**
    
    <aside>
    ➡️ 회사는 아래 데이터와 같이 채용공고를 등록합니다.
    
    </aside>
    
    ```json
    Example)
    # 데이터 예시이며, 필드명은 임의로 설정가능합니다.
    {
      "회사_id":회사_id,
      "채용포지션":"백엔드 주니어 개발자",
      "채용보상금":1000000,
      "채용내용":"원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..",
      "사용기술":"Python"
    }
    ```
    
2. **채용공고를 수정합니다.**
    
    <aside>
    ➡️ 회사는 아래 데이터와 같이 채용공고를 수정합니다. (회사 id 이외 모두 수정 가능합니다.)
    
    </aside>
    
    ```json
    Example)
    # 데이터 예시이며, 필드명은 임의로 설정가능합니다.
    {
      "채용포지션":"백엔드 주니어 개발자",
      "채용보상금":1500000, # 변경됨
      "채용내용":"원티드랩에서 백엔드 주니어 개발자를 '적극' 채용합니다. 자격요건은..", # 변경됨
      "사용기술":"Python"
    }
    
    or
    
    {
      "채용포지션":"백엔드 주니어 개발자",
      "채용보상금":1000000,
      "채용내용":"원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..",
      "사용기술":"Django" # 변경됨
    }
    ```
    
3. **채용공고를 삭제합니다.**
    
    <aside>
    ➡️ DB에서 삭제됩니다.
    
    </aside>
    
4. **채용공고 목록을 가져옵니다.**
    
    <aside>
    ➡️ 4-1. 사용자는 채용공고 목록을 아래와 같이 확인할 수 있습니다.
    
    </aside>
    
    ```json
    Example)
    [
    	{
    		"채용공고_id": 채용공고_id,
    	  "회사명":"원티드랩",
    	  "국가":"한국",
    	  "지역":"서울",
    	  "채용포지션":"백엔드 주니어 개발자",
    	  "채용보상금":1500000,
    	  "사용기술":"Python"
    	},
    	{
    		"채용공고_id": 채용공고_id,
    	  "회사명":"네이버",
    	  "국가":"한국",
    	  "지역":"판교",
    	  "채용포지션":"Django 백엔드 개발자",
    	  "채용보상금":1000000,
    	  "사용기술":"Django"
    	},
      ...
    ]
    ```
    
    <aside>
    ➡️ 4-2. 채용공고 검색 기능 구현**(선택사항 및 가산점요소).**
    
    </aside>
    
    ```json
    # Example - 1) some/url?**search=원티드**
    [
    	{
    		"채용공고_id": 채용공고_id,
    	  "회사명":"원티드랩",
    	  "국가":"한국",
    	  "지역":"서울",
    	  "채용포지션":"백엔드 주니어 개발자",
    	  "채용보상금":1500000,
    	  "사용기술":"Python"
    	},
    	{
    		"채용공고_id": 채용공고_id,
    	  "회사명":"원티드코리아",
    	  "국가":"한국",
    	  "지역":"부산",
    	  "채용포지션":"프론트엔드 개발자",
    	  "채용보상금":500000,
    	  "사용기술":"javascript"
    	}
    ]
    
    # Example - 2) some/url?**search=Django**
    [
    	{
    		"채용공고_id": 채용공고_id,
    	  "회사명":"네이버",
    	  "국가":"한국",
    	  "지역":"판교",
    	  "채용포지션":"Django 백엔드 개발자",
    	  "채용보상금":1000000,
    	  "사용기술":"Django"
    	},
    	{
    		"채용공고_id": 채용공고_id,
    	  "회사명":"카카오",
    	  "국가":"한국",
    	  "지역":"판교",
    	  "채용포지션":"Django 백엔드 개발자",
    	  "채용보상금":500000,
    	  "사용기술":"Python"
    	}
      ...
    ]
    ```
    
5. **채용 상세 페이지를 가져옵니다.**
    
    <aside>
    ➡️ 사용자는 채용상세 페이지를 아래와 같이 확인할 수 있습니다.
    
    - “채용내용”이 추가적으로 담겨있음.
    - 해당 회사가 올린 다른 채용공고 가 추가적으로 포함됩니다**(선택사항 및 가산점요소).**
    </aside>
    
    ```json
    Example)
    {
    	"채용공고_id": 채용공고_id,
      "회사명":"원티드랩",
      "국가":"한국",
      "지역":"서울",
      "채용포지션":"백엔드 주니어 개발자",
      "채용보상금":1500000,
      "사용기술":"Python",
    	"채용내용": "원티드랩에서 백엔드 주니어 개발자를 채용합니다. 자격요건은..",
    	"회사가올린다른채용공고":[채용공고_id, 채용공고_id, ..] # id List **(선택사항 및 가산점요소).**
    }
    ```
    
6. **사용자는 채용공고에 지원합니다(선택사항 및 가산점요소).**
    
    <aside>
    ➡️ 사용자는 채용공고에 아래와 같이 지원합니다. (가점 요소이며, 필수 구현 요소가 아님)
    
    - 사용자는 1회만 지원 가능합니다.
    </aside>
## 프로젝트 구현 내용

1.
<img width="1390" alt="스크린샷 2023-10-09 오후 11 37 07" src="https://github.com/Taehwan2/wantedpreonboardingbackend/assets/97010824/ebb5f383-fadb-4dad-9d96-9bfc4deaa0a7">
기능: 회사의 이름 일부로 공고를 찾는 기능


결과:

<img width="672" alt="스크린샷 2023-10-10 오전 12 00 38" src="https://github.com/Taehwan2/wantedpreonboardingbackend/assets/97010824/d70ade0a-9fbc-4102-9568-1d5f12c2b3c4">



2.
<img width="1373" alt="스크린샷 2023-10-09 오후 11 37 12" src="https://github.com/Taehwan2/wantedpreonboardingbackend/assets/97010824/6ae63d82-cc88-42ad-862c-439c071610de">
기능: 채용 공고의 세부사항을 보는 기능

결과:

<img width="732" alt="스크린샷 2023-10-10 오전 12 00 17" src="https://github.com/Taehwan2/wantedpreonboardingbackend/assets/97010824/3e8e7eac-8781-403b-9845-6b51cade8952">


3.
<img width="1402" alt="스크린샷 2023-10-09 오후 11 37 02" src="https://github.com/Taehwan2/wantedpreonboardingbackend/assets/97010824/680210ce-0286-441a-9335-0c83e37b8350">
기능: 모든 공고를 보는 기능


결과:

<img width="569" alt="스크린샷 2023-10-09 오후 11 59 58" src="https://github.com/Taehwan2/wantedpreonboardingbackend/assets/97010824/3763c8bf-f920-411b-aea3-57aa52c3ab09">


4.
<img width="1401" alt="스크린샷 2023-10-09 오후 11 36 54" src="https://github.com/Taehwan2/wantedpreonboardingbackend/assets/97010824/a22a1bef-f88f-4e35-9c7b-88e6d6439330">

기능: 공고를 수정하는 기능



5.
<img width="1401" alt="스크린샷 2023-10-09 오후 11 36 48" src="https://github.com/Taehwan2/wantedpreonboardingbackend/assets/97010824/1643b3a3-7b89-42dd-8146-3a3b0e0d1388">

기능: 공고를 지우는 기능


6.
<img width="1397" alt="스크린샷 2023-10-09 오후 11 36 44" src="https://github.com/Taehwan2/wantedpreonboardingbackend/assets/97010824/8bc035be-db96-4b53-9793-68c1d417a81e">

기능: 공고를 등록하는 기능


결과:

<img width="541" alt="스크린샷 2023-10-09 오후 11 53 44" src="https://github.com/Taehwan2/wantedpreonboardingbackend/assets/97010824/aa942cdc-2ede-40e6-972e-401b047f3e32">
<img width="650" alt="스크린샷 2023-10-09 오후 11 54 13" src="https://github.com/Taehwan2/wantedpreonboardingbackend/assets/97010824/e3d0f075-948d-4667-b47c-4b0e9b1b3dab">
<img width="831" alt="스크린샷 2023-10-09 오후 11 54 29" src="https://github.com/Taehwan2/wantedpreonboardingbackend/assets/97010824/0e5f963c-266e-4a5f-95ff-89af85c7caee">
<img width="777" alt="스크린샷 2023-10-09 오후 11 54 39" src="https://github.com/Taehwan2/wantedpreonboardingbackend/assets/97010824/13471555-83db-4a32-951d-d49b5fc63857">


7.
<img width="1374" alt="스크린샷 2023-10-09 오후 11 36 37" src="https://github.com/Taehwan2/wantedpreonboardingbackend/assets/97010824/25d3433a-db88-4211-bbf1-754894d406ce">

기능: 회사를 등록하는 기능


결과:

<img width="403" alt="스크린샷 2023-10-09 오후 11 59 05" src="https://github.com/Taehwan2/wantedpreonboardingbackend/assets/97010824/1177de79-c08d-4591-bcd7-c998ac588585">


8.
<img width="1376" alt="스크린샷 2023-10-09 오후 11 37 16" src="https://github.com/Taehwan2/wantedpreonboardingbackend/assets/97010824/d83b1439-1eca-4760-8009-83b7f98cb5bf">

기능: 채용공고 하나만 보는 기능


결과:



9.
<img width="1321" alt="스크린샷 2023-10-09 오후 11 37 21" src="https://github.com/Taehwan2/wantedpreonboardingbackend/assets/97010824/cf7f2401-3076-4ae4-b237-1f5297ab0e4e">

기능: 회원을 등록하는 기능


결과:

<img width="617" alt="스크린샷 2023-10-10 오전 12 01 10" src="https://github.com/Taehwan2/wantedpreonboardingbackend/assets/97010824/1c463538-9454-4d34-b9ea-eb782b421cc5">


10.
<img width="1400" alt="스크린샷 2023-10-09 오후 11 37 23" src="https://github.com/Taehwan2/wantedpreonboardingbackend/assets/97010824/3e56c9f2-c596-41ac-bba0-f90469bc3d40">

기능: 사용자가 채용공고를 등록하는 기능


결과:
<img width="590" alt="스크린샷 2023-10-10 오전 12 01 25" src="https://github.com/Taehwan2/wantedpreonboardingbackend/assets/97010824/66a00f4b-7b94-42ed-9cbd-b8735369db07">

2개이상의 회사에 지원할 경우

<img width="598" alt="스크린샷 2023-10-10 오전 12 01 36" src="https://github.com/Taehwan2/wantedpreonboardingbackend/assets/97010824/5d386615-7bae-4886-b8b5-3d925c688add">


### BE
#### 장태환
## 프로젝트 한계 
1. 기본적인 CRUD라서 테스트 케이스 작성 요소가 부족함. -> 하지만 추후에 리펙토링 하면서 기본적인 테스트 코드도 추가 예정
2. 주석이 부족함 단기간 작성코드라 여러가지 수정요소가 필요
3. index도 활용하여 jmeter로 효과 확인 예정
   


  
