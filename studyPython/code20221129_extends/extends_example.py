#객체 지향 프로그래밍
# class : 객체 덩어리 만들기 (설계도)
# istance : class 기반으로 찍어내는 것
# inheritance : 부모클래스의 자원을 물려 받는 것
# 자바의 경우 필드, 생성자 , 메서드
# 파이썬은 자바 처럼 명확한 규칙이 없으므로 개발자의 상황에 따라 객체 지향 프로그래밍을 할 수 있는 유연성을 가지고 있다 규칙이 없다 자율적
#
# 회원 정보를 상속받는 포트폴리오 class
# 1. 회원 class id, pw ,email, name 필드값을 갖는 user1 인스턴스를 생성하고 회원정보를
# 조회하는 메서드 def 를 만들고
# 2. 포트 폴리오 class는 회원 class를 상속받고 회원 정보를 조회하는 메서드 실행

class account:
    # 필드
    id = "abcd"
    pw = "1234"
    email = "a@a"
    name ="ㄱㅈㅎ"
    # 생성자
    def method1(self):
        return "abc"
accountExample = account()

print(accountExample.id)
print(accountExample.pw)
print(accountExample.email)
print(accountExample.name)

class portfolio(account):
    def infoOutput(self):
        print(self.id)
        print(self.email)

# portfolioExample이라는 변수명은 portfolio class 기반의 인스터느이다
# 인스턴스를 생성할 때 부모클래스 account가 있다
# account 인스턴스를 먼저 만들고 매개변수로 portfolio클래스에 전달한다
# portfolioExample 인스턴스를 생성한다 //부모클래스의 자원은 모두 생성된 상태

portfolioExample = portfolio()
print(portfolioExample.infoOutput())