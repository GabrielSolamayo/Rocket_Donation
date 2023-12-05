const slider = document.querySelector(".slider");
const cards = document.querySelectorAll(".card__institute");
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

function updateSearchBar() {
    var selectedCategory = document.getElementById('categoryFilter').value;
    var selectedDonations = Array.from(document.querySelectorAll('input[name="donation"]:checked'))
                                .map(function(checkbox) { return checkbox.value; })
                                .join(', ');

    var searchString = selectedCategory + (selectedDonations ? ', ' + selectedDonations : '');
    document.getElementById('searchInput').value = searchString;
  }

  function performSearch() {
    var searchQuery = document.getElementById('searchInput').value;
    alert('Realizando pesquisa com: ' + searchQuery);
    // Adicione aqui a lógica real de pesquisa ou redirecionamento.
  }

  document.getElementById('categoryFilter').addEventListener('change', updateSearchBar);

  var donationCheckboxes = document.querySelectorAll('input[name="donation"]');
  donationCheckboxes.forEach(function(checkbox) {
    checkbox.addEventListener('change', updateSearchBar);
  });
