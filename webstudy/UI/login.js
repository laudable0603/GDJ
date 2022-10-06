//비밀번호 입력없이 Sign In 버튼 누르면 경고창 띄우기(비밀번호를 입력하세요.)
document.getElementById('btn_signin').onclick = function(ev){
    var pw = document.getElementById('pw');
    var id = document.getElementById('id');
    if(id.value.length < 4){
        alert('아이디는 4자 이상입니다.');
        ev.preventDefault();
        return;
    }
    if(pw.value == ''){
        alert('비밀번호를 입력하세요.');
        ev.preventDefault();//서브밋 막을 때 자주 사용
        return;//이벤트 취소후 세트로 넣어주는게 좋다.
    }
}
document.getElementById('id').onkeyup = function(event){
    
    var id_msg = document.getElementById('id_msg');
    if(id.value.length == 0){
        id_msg.textContent= '';
       
    } else if (id.value.length < 4){
        id_msg.textContent = '아이디는 4자 이상입니다.';
        
        
    } else if(id.value.length >=4){
        id_msg.textContent= '정상적인 아이디입니다.';
    }
}