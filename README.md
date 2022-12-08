# naver_movie_review.ipynb 


## 프로젝트를 시작하는 방법
` 이 코드는 구글 코랩 기반으로 작성되었습니다.`  
` 코드 상단의 open in colab 버튼을 누르면 코랩 환경에서 작동 가능합니다.`
- 리뷰를 찾고싶은 영화 제목을 입력한다.<br/><br/>
![movie_list](./image/img2.png)
- 입력한 영화 제목이 포함된 모든 영화 정보와 포스터 출력<br/><br/>
![movie_list](./image/img1.png)
- 그 중 원하는 영화의 순서(1~n)를 입력<br/><br/>
![movie_find](./image/img3.png)
- 네이버 영화리뷰 한 페이지 리뷰 크롤링할 때마다 "페이지n 리뷰" 출력<br/><br/>
![movie_find](./image/img4.png)<br/>
네이버 영화 리뷰 클롤링 결과 확인(데이터 프레임에 데이터 저장하면서 크롤링)
![movie_find](./image/img5.png)
- 리뷰 중 결측치 제거와 리뷰 데이터 개요 출력<br/><br/>
![movie_find](./image/img6.png)
- 리뷰 파일을 csv파일형태로 저장<br/>
- 한국어 형태소 분석기 설치<br/>
- 리뷰를 토큰화 후 관련 없는 용어를 제거<br/><br/>
제거 후 남은 용어 예시<br/>
![movie_find](./image/img7.png)
- 영화 리뷰 중 빈도수가 높은 단어를 그래프와 wordcloud로 표현<br/><br/>
![movie_find](./image/img8.png)<br/>
`아래 이미지는 깃허브가 day모드로 설정해야 세로축의 글자가 보인다.`
![movie_find](./image/img9.png)
![movie_find](./image/img10.png)
- 단어 그래프의 한글 깨짐 현상을 해결하기 위해 폰트 설정 코드
- 출현빈도 높은 단어 wordcloud방식으로 출력<br/><br/>
- 다른 분의 영화 리뷰 데이터로 학습하는 자연어처리 감정분석 딥러닝 실행<br/><br/>
`코랩 무료 버전으로는 대략 40분~1시간 정도 걸림`<br/>
![movie_find](./image/img11.png)<br/>
<br/>
2 labels, 44682 dataset<br/>
label counts:: Counter({1: 22512, 0: 22170})<br/><br/>
train-dataset is prepared<br/>
<br/>

======== Epoch 1 / 3 ========<br/>
<br/>
  Train loss: 0.31, Train Accuracy: 0.87<br/>
  Training epcoh took: 0:13:04<br/>
<br/>
Running Validation...<br/>
  Validation Accuracy: 0.88<br/>
  Validation took: 0:00:29<br/>
             |비고|precision   |recall |f1-score  |support|<br/>
<br/>
|---|---|---|---|---|
          |0      |0.85     |0.92     |0.88     |2177|<br/>
          |1      |0.92     |0.85     |0.88     |2292|<br/>
<br/>
    accuracy                           0.88      4469<br/>
   macro avg       0.88      0.88      0.88      4469<br/>
weighted avg       0.89      0.88      0.88      4469<br/>
<br/>
<br/>
======== Epoch 2 / 3 ========<br/>
<br/>
  Train loss: 0.19, Train Accuracy: 0.93<br/>
  Training epcoh took: 0:13:00<br/>
<br/>
Running Validation...<br/>
  Validation Accuracy: 0.90<br/>
  Validation took: 0:00:29<br/>
              precision    recall  f1-score   support<br/>
<br/>
           0       0.90      0.90      0.90      2177<br/>
           1       0.90      0.90      0.90      2292<br/>
<br/>
    accuracy                           0.90      4469<br/>
   macro avg       0.90      0.90      0.90      4469<br/>
weighted avg       0.90      0.90      0.90      4469<br/>
<br/>
<br/>
======== Epoch 3 / 3 ========<br/>
<br/>
  Train loss: 0.11, Train Accuracy: 0.96<br/>
  Training epcoh took: 0:13:00<br/>
<br/>
Running Validation...<br/>
  Validation Accuracy: 0.90<br/>
  Validation took: 0:00:29<br/>
              precision    recall  f1-score   support<br/>
<br/>
           0       0.91      0.89      0.90      2177<br/>
           1       0.89      0.91      0.90      2292<br/>
<br/>
    accuracy                           0.90      4469<br/>
   macro avg       0.90      0.90      0.90      4469<br/>
weighted avg       0.90      0.90      0.90      4469<br/>
<br/>
<br/>
Training complete!<br/>
- 학습된 딥러닝으로 현재 크롤링한 리뷰 데이터에 대한 긍정, 부정 예측<br/><br/>
![movie_find](./image/img12.png)
