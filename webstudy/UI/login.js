
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
        ev.preventDefault();
        return;
    }
}
document.getElementById('id').onkeyup = function(event){
    
    var id_msg = document.getElementById('id_msg');
    if(id.value.length == 0){
        id_msg.textContent= '';
       
    } else if (id.value.length < 4){
        id_msg.textContent = '아이디는 4자 이상입니다.';
        id_msg.style.color = "#ff0000";
        id_msg.style.fontSize= "14px";
        
        
    } else if(id.value.length >=4){
        id_msg.textContent= '정상적인 아이디입니다.';
        id_msg.style.color = "#0000FF";
        id_msg.style.fontSize= "14px";
    }
}