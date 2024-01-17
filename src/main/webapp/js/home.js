const slides = document.querySelectorAll(".slide");
const slideshow = document.querySelector(".slideshow");

// Set the width of the slideshow to be the total width of all slides
slideshow.style.width = `${slides.length * 100}%`;

// Set the width of each slide to be a fraction of the total width
slides.forEach(slide => {
	slide.style.width = `${100 / slides.length}%`;
});

const listImage = document.querySelector(".slideshow");
const imgs = document.querySelectorAll(".slide");
const length = imgs.length;

let current = 0;

const handleRightSlide = () => {
	if (current == length) {
		current = 0;
		listImage.style.transform = `translateX(0px)`;
	} else {
		let width = imgs[0].offsetWidth;
		listImage.style.transform = `translateX(${width * -1 * current}px)`;
	}
	current++;
};

let handleEvent = setInterval(handleRightSlide, 2500);        