select = $('#select');
input = $('.form__input');
contributions = $('.main-block__content');

$(document).on('click', '#form__button', function() {
    $.get(`/filter?category=${select.val() ? select.val() : 'all'}&search=${input.val()}`, function(resp) {
        console.log(resp);
        contributions.html(resp);
        contributions.innerHTML += resp;
    });
});