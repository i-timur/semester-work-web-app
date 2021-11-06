let reg = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])[0-9a-zA-Z]{8,}$/;

let inp = document.querySelector('#password');
let validationEl = document.querySelector('.validation-text');

document.querySelector('.login__submit').onclick = (e) => {
    if (!isValid(reg, inp.value)) {
        e.preventDefault();
        invalid(inp, validationEl, 'Пароль должен состоять из лат. букв, содержать хотя бы 1 заглавную букву, 1 маленькую букву, одну цифру и состоять не менее, чем из 8 символов');
    } else {
        valid(inp, validationEl, '');
    }
}

function isValid(reg, inp) {
    return reg.test(inp);
}

function invalid(inp, el, msg) {
    inp.classList.remove('valid');
    inp.classList.add('invalid');
    el.innerHTML = msg;
}

function valid(inp, el, msg) {
    inp.classList.remove('invalid');
    inp.classList.add('valid');
    el.innerHTML = msg;
}
