document.addEventListener("DOMContentLoaded", function () {
    const zoomableImages = document.querySelectorAll(".zoomable-image");
    const zoomedImages = document.querySelectorAll(".zoomable-image-on-scean");

    zoomableImages.forEach((img) => {
        img.addEventListener("click", () => {
            const targetId = img.getAttribute("data-target");
            const zoomed = document.getElementById(targetId);

            if (!zoomed) {
                console.warn("No corresponding zoomed image found for", img);
                return;
            }

            // Toggle zoom
            const isZoomed = zoomed.classList.contains("zoomed");
            if (isZoomed) {
                zoomed.classList.remove("zoomed");
                setTimeout(() => zoomed.classList.add("d-none"), 500); // скрываем после анимации
            } else {
                zoomed.classList.remove("d-none");
                setTimeout(() => zoomed.classList.add("zoomed"), 10); // небольшой таймаут для анимации
            }
        });
    });

    // Закрытие по клику на zoomed-изображение
    zoomedImages.forEach((img) => {
        img.addEventListener("click", () => {
            img.classList.remove("zoomed");
            setTimeout(() => img.classList.add("d-none"), 500);
        });
    });
});

document.addEventListener("DOMContentLoaded", function () {
    // Получаем все кнопки, которые открывают модальное окно
    const workButtons = document.querySelectorAll(".Work__Exampl_btn");

    workButtons.forEach((button, index) => {
        // Генерируем уникальный id модалки для каждой карточки
        const modalId = "exampleModal" + index;
        const modalElement = document.getElementById(modalId);

        if (!modalElement) {
            console.warn(`Modal with id ${modalId} not found for button`, button);
            return;
        }

        // Устанавливаем правильный data-bs-target у кнопки
        button.setAttribute("data-bs-target", `#${modalId}`);

        // Создаём экземпляр Bootstrap Modal
        const modal = new bootstrap.Modal(modalElement);

        // Навешиваем обработчик клика на кнопку
        button.addEventListener("click", function () {
            modal.show();
        });
    });
});
