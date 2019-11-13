$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "/users/1"
    }).then(function (data) {
        $('#id').text(data.id);
        $('#name').text(data.nome);
    });
});
