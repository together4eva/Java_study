# import Flask : Flask 패키지를 연결
from flask import Flask
# app이라는 변수에 Flask(__name__)을 할당
app = Flask(__name__)

# route : 경로 : http://localhost:8080/[경로]
# spring의 @Mapping과 유사 = @app.route()
@app.route('/api')
def api():
    #Public String = def
    #메스드명(매개변수) = api(매개변수)
    # {} = :

    # @ResponseBody = 문자열 리턴
    return "api test"

# GetMappingURL 매개변수
# <source_var> : URL문자열을 매개변수로 받음
# spring의 @PathVariable과 동일
@app.route('/api/<source_var>')
def api_source_var(source_var):
    source_var = source_var + "마바사"
    return source_var
# app변수에 있는 flask의 run메서드 실행
# 인자값은 host와 port
app.run(host="localhost", port=5001)
# *flask
# 파이썬 언어 기반 "경량" 프레임워크 <> Django
#
# *http 1.1
# 첫 표준버전, 한 번 요청 한 번 리턴
# *http 2.0
# tcp +  멀티 플렉스 (병렬처리)
# *http 3.0
# udp + 멀티 플렉스
#
# *tcp : 신뢰기반 프로토콜 : 순서와 도착 확인 네트워크
# *udp : 속도중심 프로토콜 : 데이터 던지면 끝
