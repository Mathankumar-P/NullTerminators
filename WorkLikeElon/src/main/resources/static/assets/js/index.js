// Sidebar active listeners based on event
// Get sidebar links by their IDs
const homeLink = document.getElementById('home-link');
const todoLink = document.getElementById('todo-link');
const focusLink = document.getElementById('focus-link');
const motivationLink = document.getElementById('motivation-link');
const logoutLink = document.getElementById('logout-link');

 // Function to handle click event and change link color
 function changeLinkColor(link) {
    // Remove 'active' class from all links
    homeLink.classList.remove('active');
    todoLink.classList.remove('active');
    focusLink.classList.remove('active');
    motivationLink.classList.remove('active');
    logoutLink.classList.remove('active');

    // Add 'active' class for the clicked link
    link.classList.add('active');
}

function loadContent(contentUrl) {
    fetch(contentUrl)
        .then(response => response.text())
        .then(data => {
            mainContent.innerHTML = data; // Replace the main content with fetched data
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

// Add click event listeners to the links
homeLink.addEventListener('click', function(event) {
    changeLinkColor(homeLink);
    window.location.href='index.html';
    event.preventDefault(); // Prevent default behavior of the link
});

todoLink.addEventListener('click', function(event) {
    changeLinkColor(todoLink);
    event.preventDefault(); // Prevent default behavior of the link
});

focusLink.addEventListener('click', function(event) {
    changeLinkColor(focusLink);
    window.location.href='focus.html';
    event.preventDefault(); // Prevent default behavior of the link
});

motivationLink.addEventListener('click', function(event) {
    changeLinkColor(motivationLink);
    event.preventDefault(); // Prevent default behavior of the link
});
logoutLink.addEventListener('click', function(event) {
    changeLinkColor(logoutLink);
    event.preventDefault(); // Prevent default behavior of the link
});

//quote generator api
const quote = document.getElementById("quote");
const author = document.getElementById("author");
const api_url = "https://api.quotable.io/random"
async function getQuote (url){
    const response = await fetch(url);
    var data = await response.json();
    console.log(data);
    quote.innerHTML=data.content;
    author.innerHTML=data.author;
}

getQuote(api_url);

// side bar transition

const sideMenu = document.querySelector("aside");
const menuBtn = document.querySelector("menu-btn");
const closeBtn = document.querySelector("close-btn");

menuBtn.addEventListener('click',()=>{
    sideMenu.style.display='block';
})
closeBtn.addEventListener('click',()=>{
    sideMenu.style.display='none';
})
