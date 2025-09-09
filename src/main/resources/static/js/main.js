document.addEventListener("DOMContentLoaded", function () {
    const form = document.getElementById("formSubmit");

    form.addEventListener("submit", function (event) {
        event.preventDefault(); // Блокируем стандартную отправку

        // Проверяем валидность формы
        if (!form.checkValidity()) {
            event.stopPropagation();
            form.classList.add('was-validated'); // добавляем стили Bootstrap
            return; // прерываем выполнение — отправка не произойдет
        }

        // Если форма валидна — отправляем через fetch
        fetch(form.action || '/send', {
            method: 'POST',
            body: new FormData(form)
        })
            .then(response => {
                if (response.ok) {
                    // Открываем модальное окно при успешной отправке
                    const myModal = new bootstrap.Modal(document.getElementById('exampleModal1'));
                    myModal.show();
                    form.reset(); // очищаем форму
                    form.classList.remove('was-validated'); // убираем подсветку ошибок
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