const slider = document.querySelector(".slider");
const cards = document.querySelectorAll(".card__news");
const prevButton = document.querySelector(".prev-button");
const nextButton = document.querySelector(".next-button");
let currentIndex = 0;

function nextSlide() {
    currentIndex = (currentIndex + 1) % cards.length;
    updateSlider();
}

function previousSlide() {
    currentIndex = (currentIndex - 1 + cards.length) % cards.length;
    updateSlider();
}

function updateSlider() {
    const translateX = currentIndex * -cards[0].offsetWidth;
    slider.style.transform = `translateX(${translateX}px)`;
}

nextButton.addEventListener("click", nextSlide);
prevButton.addEventListener("click", previousSlide);

updateSlider();