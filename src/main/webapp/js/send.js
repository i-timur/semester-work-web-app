$(document).on('click', '.submit', (e) => {
    e.preventDefault();
    $.post('/send', {message: $('.text').val()},(resp) => {
        console.log('Posted message!');
        $('.text').val('');
        console.log(resp);
        $('.chat__messages').html(resp);
    });
});