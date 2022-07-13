# #요일 구하기
# – 사용자로부터 날짜(연,월,일) 정보를 입력 받아서 해당 날짜에 해당하
# 는 요일(월~일)을 출력하는 프로그램을 작성하시오.
# – 힌트: 1년 1월 1일은 월요일이다


##년도 계산하기
year = int(input("년도를 입력하세요: "))
month = int(input("월을 입력하세요: "))
date = int(input("일을 입력하세요: "))

total_day = 0

for each_year in range(1, year):
    if each_year % 400 == 0 or (each_year % 4 == 0 and not(each_year % 100 == 0)): #윤년일떄
        total_day += 366
    else:
        total_day += 365

#월 계산하기, 내가 못한것 월의 누적합계를 못 구한것 같은데 아닌가?

for each_month in range(1, month):
    if each_month == 4 or each_month == 6 or each_month == 9 or each_month == 11:  # 30일 일떄, 4,6,9,11월
        total_day += 30
    elif each_month == 1 or each_month == 3 or each_month == 5 or each_month == 7 or each_month == 8 or each_month == 10 or each_month == 12:  # 31일때 1,3,5,7,8,10,12
        total_day += 31
    elif (each_month == 2) and year % 400 == 0 or (year % 4 == 0 and not (year % 100 == 0)):  ##2월일수 구하기윤년일떄 n 28일, 29일
        total_day += 29
    else:
        total_day += 28

##일수 계산하기

total_day += date

#최종 구하기

if (total_day % 7) == 1:
    day = "월요일"
if (total_day % 7) == 2:
    day = "화요일"
if (total_day % 7) == 3:
    day = "수요일"
if (total_day % 7) == 4:
    day = "목요일"
if (total_day % 7) == 5:
    day = "금요일"
if (total_day % 7) == 6:
    day = "토요일"
if (total_day % 7) == 0:
    day = "일요일"


#
print(f"{year}년 {month}월 {date}일은 {day}입니다")  ##몇월 몇일은 무슨 요일입니다 못함



