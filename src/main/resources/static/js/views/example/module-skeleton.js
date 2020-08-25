const module = (function (global, $, _, moment, thisPage) {

    /***************************************************************************
     * @ 모듈 변수(상수) 선언
     **************************************************************************/
    const CTX = thisPage['ctxPath'];
    // class 정의
    // const, let 정의

    /***************************************************************************
     * @ 모듈 함수 선언
     **************************************************************************/
    // function 사용자_정의_함수() {
    //
    // }

    /***************************************************************************
     * @ jquery 이벤트 등록
     **************************************************************************/
    function moduleEventHandlers() {

    }

    /***************************************************************************
     * @ 화면 로딩 시 최초로 실행할 함수 선언
     **************************************************************************/
    function moduleInitializr() {
        // 정의된_사용자_함수_중_화면_최초_로딩시_호출된_함수();

    }


    /***************************************************************************
     * @ DOM Ready 실행
     **************************************************************************/
    $(function () {
        moduleEventHandlers();
        moduleInitializr();
    });

    /***************************************************************************
     * @ 외부로 노출할 함수 선언
     **************************************************************************/
    return {

    };


})(window, jQuery, _, moment, thisPage);