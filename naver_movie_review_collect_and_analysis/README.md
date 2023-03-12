# 원하는 네이버 영화 리뷰 수집, 분석
![book_cover](https://user-images.githubusercontent.com/86425607/224525279-1dc7891c-186e-4040-8cf9-8b51daac4fb2.png)
<br/><br/>

## License
`BSD 2-Clause "Simplified" License`
<br/><br/>

## Motivation
이 프로젝트는 자연어 처리 연구를 하는 분들의 데이터 수집에 대한 수고를 덜도록 하기 위해 실행되었다.
또한 한국어 자연어처리 분야가 더 성장했으면 하는 바램으로 하게 되었다.
<br/><br/>

## Description
영화 제목을 입력하면 해당 제목의 네이버 영화 리뷰 데이터와 평점을 수집, 저장한 후 딥러닝을 통한 감정분석(0: 부정, 1: 긍정)으로 수집한 리뷰에서 긍/부정 비율 측정
<br/><br/>

## Environment
google colab <br/>
python 3.8.15 <br/><br/>

## Usage of Library, Package, Module
- BeautifulSoup
- urllib
- pandas
- requests
- cv2
- numpy
<br/><br/>

## Reference
beautifulsoup 사용법 : [Beautiful_Soup_Documentation](https://www.crummy.com/software/BeautifulSoup/bs4/doc/)
<br/>
한글 폰트 설정 :  [colab 사용시 한글 깨짐 현상 해결](https://didalsgur.tistory.com/entry/Python-Colab-%EC%82%AC%EC%9A%A9-%EC%8B%9C-%ED%95%9C%EA%B8%80-%EA%B9%A8%EC%A7%90-%ED%98%84%EC%83%81-%ED%95%B4%EA%B2%B0-feat-matplotlib)
<br/>
리뷰 데이터 불용어 제거, 바차트, wordcloud 등 분석 코드 : [이수안컴퓨터연구소_유튜브](https://youtu.be/RgKzmJQf21s)
<br/>
BERT 사용 코드 : [kiyoungkim1's github](https://github.com/kiyoungkim1/ReadyToUseAI), 
                  [kiyoungkim1's youtube](https://youtu.be/9HDBKS4j64M)
<br/><br/>

## Shortcoming
- 리뷰를 파일로 저장한 후에 다시 파일을 불러오는 도중 결측치가 발생하는 경우가 있다.
- 마지막 셀의 코드에서 `logit = CLS.inference(sentences=review_list)` 입력 파일에 크기가 큰 파일은 코랩 기본 버전으로는 사용할 수 없다. 파일을 여러개로 쪼개서 차례로 입력하거나 코랩 프로 버전을 사용하면 가능할 것이다. 예시로 코랩 무로 버전에서 '인터스텔라' 영화의 4만건 이상의 리뷰 데이터를 입력했다가 중단됨.
- 리뷰 데이터를 review라는 변수에 받지만 뒤에서 BERT모델에 넣어주려고 하니 저장됐던 review를 데이터가 아닌 문자열로 인식하는 문제가 있어서 중간에 따로 파일로 저장했던 것이다.<br/>
아마 BERT모델 학습 시간에 오랜 시간이 걸리다보니 review에 저장했던 데이터가 소실된 것 같다.
<br/>

## What to do next
- 리뷰가 계속해서 새로 생기므로 매번 리뷰 전체를 긁어오는 것이 아닌 새롭게 생성된 데이터만 추가적으로 가져오는 자동화 시스템
- 로그, 이미지 등 다양한 것을 크롤링 기술 학습
<br/><br/>

## code execution process
` 이 코드는 구글 코랩 기반으로 작성되었습니다.`  
` 코드 상단의 open in colab 버튼을 누르면 코랩 환경에서 작동 가능합니다.`<br/>

1. 리뷰를 찾고싶은 영화 제목을 입력하면 `movie_name`변수에 저장.<br/>
![movie_list](https://user-images.githubusercontent.com/86425607/224525650-80954e7f-0094-4766-aabe-27d4cb3d0f2e.png)<br/><br/>

1. 입력한 영화 제목이 포함된 모든 영화 정보와 포스터 출력<br/>
![movie_list](https://user-images.githubusercontent.com/86425607/224525687-fd88f729-15d8-4782-855f-e2f6c5a4cd65.png)<br/>
- 이 페이지에서 `search_list_1` class에서 영화 포스터, 정보를 추출한다.<br/><br/>
![movie_lists](https://user-images.githubusercontent.com/86425607/224525731-4d6cd892-5fca-4607-9832-7af2db49e914.png)<br/>
- 검색어 관련 영화가 많은 경우 `더많은 영화보기` 버튼을 눌렀을 때 이동하는 영화 목록 사이트의 url인 `more_list` class의 `href값`을 추출해서 영화 목록 페이지에서 크롤링 시작<br/>
- 다음 페이지의 영화 목록을 크롤링해야 할 때는 다음 페이지 url인 `td`의 `next` class의 `href값` 추출해서 url변수에 저장<br/><br/>
- 각 영화 리뷰 페이지는 `https://movie.naver.com/movie/bi/mi/pointWriteFormList.naver?code=`에 영화코드가 붙여진 페이지에 있다. 그래서 영화 목록을 크롤링할 때 `movie_codes` 리스트에 각 영화의 영화코드를 추출해서 저장한다.<br/>
![movie_list](https://user-images.githubusercontent.com/86425607/224525793-2b51aeeb-3b8f-4f70-816e-82f846048480.png)<br/>
- 각 영화 목록의 순서 - 1이 movie_codes리스트의 인덱스다.<br/><br/>

1. 그 중 원하는 영화의 순서(1~n)를 입력<br/>
![movie_find](https://user-images.githubusercontent.com/86425607/224525828-08970602-9737-4700-a5ea-daddea37e618.png)<br/>
- 영화의 순서를 입력하면 해당하는 영화코드를 `search_movie_code` 변수에 저장<br/><br/>

1. 영화 평점, 리뷰 크롤링<br/>
![movie_find](https://user-images.githubusercontent.com/86425607/224525855-5c428911-c191-4cf3-b9b8-921a456b707e.png)<br/>
- 영화 평점과 리뷰를 저장할 데이터프레임 생성<br/>
- 평점은 `em`태그에서 추출
- 리뷰는 `filtered_ment_숫자` id에서 추출<br/> 
ex) 첫번째 리뷰 = filtered_ment_0, 2번째 리뷰 = filtered_ment_1
- 다음 페이지 이동은 `pg_next` class에서 `href값` 추출해서 url변경해서 이루어진다.
- 네이버 영화리뷰 한 페이지 리뷰 크롤링할 때마다 "페이지n 리뷰" 출력
<br/><br/>

## 네이버 영화 리뷰 크롤링 결과 확인<br/>
`review` 변수에 크롤링 결과 저장<br/>
![movie_find](https://user-images.githubusercontent.com/86425607/224525903-2eebdbfa-d301-4df1-90d6-621e19bd1ea7.png)
<br/><br/>

1. 데이터 결측치 제거와 리뷰 데이터 개요 출력<br/>
![movie_find](https://user-images.githubusercontent.com/86425607/224525937-5e1b2851-d217-40bd-bad7-5731ddecc3f4.png)
<br/><br/>

1. 리뷰 파일을 csv파일형태로 저장<br/>
- utf-8로 encoding
<br/><br/>

***
`아래의 코드부터는 외부 코드 복사`<br/>
`리뷰 데이터만을 원한다면 이전 셀까지만 실행하면 된다.`
***

1. 한국어 형태소 분석기 설치
<br/><br/>

1. 리뷰를 토큰화 후 관련 없는 용어를 제거<br/>
제거 후 남은 용어 예시<br/>
![movie_find](https://user-images.githubusercontent.com/86425607/224525971-bc3ee89e-9914-47ec-9b0e-46736805f9ce.png)
<br/><br/>

1. 영화 리뷰 중 빈도수가 높은 단어를 그래프와 wordcloud로 표현<br/>
![movie_find](https://user-images.githubusercontent.com/86425607/224525999-77f1f085-a11d-4b7d-ac75-d350a1302869.png)<br/>
`아래 이미지는 깃허브가 day모드로 설정해야 세로축의 글자가 보인다.`
![movie_find](https://user-images.githubusercontent.com/86425607/224526025-afd89d15-c8de-4400-9ce6-abf9aae3a626.png)<br/>
![movie_find](https://user-images.githubusercontent.com/86425607/224526052-6c703db9-b83f-41f9-abef-cf535c84ff1a.png)<br/><br/>

1. 네이버 영화 리뷰와 긍/부정 레이블 데이터를 BERT에 학습시킨다.<br/>
`코랩 무료 버전으로는 대략 40분~1시간 정도 걸림`<br/>
![movie_find](https://user-images.githubusercontent.com/86425607/224526073-58fc0e9c-c819-4cb1-954c-81aec9c6f28a.png)<br/><br/>

1. BERT fine-tuning을 이용해서 현재 크롤링한 리뷰 데이터의 대한 긍/부정 예측 후 긍/부정 비율 출력<br/>
![movie_find](https://user-images.githubusercontent.com/86425607/224526098-0352976a-ca79-4c47-8229-6be0acc893fc.png)
