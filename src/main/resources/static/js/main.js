document.addEventListener("DOMContentLoaded", function() {
    const form = document.getElementById("formSubmit");

    form.addEventListener("submit", function(event) {
        event.preventDefault(); // блокируем стандартную отправку

        // отправляем форму через fetch автоматически
        fetch(form.action || '/send', {
            method: 'POST',
            body: new FormData(form)
        })
            .then(response => {
                if (response.ok) {
                    // открываем модальное окно
                    const myModal = new bootstrap.Modal(document.getElementById('exampleModal1'));
                    myModal.show();
                    form.reset(); // очищаем форму
                } else {
                    alert("Błąd przy wysyłaniu danych");
                }
            })
            .catch(error => {
                console.error('Error:', error);
                alert("Błąd sieci");
            });
    });
});