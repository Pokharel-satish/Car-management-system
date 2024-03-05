let menubar = document.querySelector('#menu-bars')
let mynav = document.querySelector('.navbar');

menubar.onclick = () =>{
    menubar.classList.toggle('fa-times');
    mynav.classList.toggle('active');
}
document.addEventListener("DOMContentLoaded", function () {
    const registrationForm = document.getElementById("registration-form");
  
    registrationForm.addEventListener("submit", function (event) {
      event.preventDefault(); // Prevent actual form submission
  
      const name = document.getElementById("name").value;
      const address = document.getElementById("address").value;
      const phone = document.getElementById("phone").value;
      const email = document.getElementById("email").value;
      const username = document.getElementById("username").value;
      const password = document.getElementById("password").value;
  
      // Client-side validation
      if (!name || !address || !phone || !email || !username || !password) {
        alert("Please fill in all fields.");
        return;
      }
  
      // Simulate backend logic (in a real scenario, use AJAX or fetch to send data to the server)
      const userData = {
        name: name,
        address: address,
        phone: phone,
        email: email,
        username: username,
        password: password,
      };
  
      // Display success message (replace this with server response)
      alert("Registration successful!");
  
      // Clear form after successful registration
      registrationForm.reset();
    });
  });
  document.addEventListener("DOMContentLoaded", function () {
    const loginForm = document.getElementById("login-form");
  
    loginForm.addEventListener("submit", function (event) {
      event.preventDefault();
  
      const username = document.getElementById("username").value;
      const password = document.getElementById("password").value;
  
      if (!username || !password) {
        alert("Please fill in both fields.");
        return;
      }
  
      // Simulate login success (replace with actual login logic)
      alert("Login successful!");
      window.location.href = "seller.html";
    });
  });
  document.addEventListener("DOMContentLoaded", function () {
    const addCarForm = document.getElementById("add-car-form");
  
    addCarForm.addEventListener("submit", function (event) {
      event.preventDefault();
  
      const make = document.getElementById("make").value;
      const model = document.getElementById("model").value;
      const year = document.getElementById("year").value;
      const mileage = document.getElementById("mileage").value;
      const location = document.getElementById("location").value;
      const price = document.getElementById("price").value;
  
      if (!make || !model || !year || !mileage || !location || !price) {
        alert("Please fill in all fields.");
        return;
      }
  
      // Simulate car added (replace with actual backend logic)
      alert("Car added successfully!");
      addCarForm.reset();
    });
  });
  document.addEventListener("DOMContentLoaded", function () {
    const inputs = document.querySelectorAll("input");
    const buttons = document.querySelectorAll("button");
  
    // Event listeners for input fields
    inputs.forEach(input => {
      input.addEventListener("focus", function () {
        this.style.backgroundColor = "yellow";
      });
  
      input.addEventListener("blur", function () {
        this.style.backgroundColor = "white";
      });
    });
  
    // Event listeners for buttons
    buttons.forEach(button => {
      button.addEventListener("mouseover", function () {
        this.style.backgroundColor = "lightblue";
      });
  
      button.addEventListener("mouseout", function () {
        this.style.backgroundColor = "";
      });
    });
  });
  document.addEventListener("DOMContentLoaded", function () {
    const searchForm = document.getElementById("search-form");
    const searchResults = document.getElementById("search-results");
  
    searchForm.addEventListener("submit", function (event) {
      event.preventDefault();
  
      const model = document.getElementById("model").value;
      const location = document.getElementById("location").value;
  
      // Simulate search results (replace with actual data retrieval)
      const results = [
        { make: "Toyota", model: "aaa", year: 2022, location: "perth" },
        { make: "Honda", model: "yyy", year: 2002, location: "sydney" },
        // Add more results here
      ];
  
      // Display search results
      displayResults(results);
    });
  
    function displayResults(results) {
      searchResults.innerHTML = "";
  
      if (results.length === 0) {
        searchResults.innerHTML = "<p>No results found.</p>";
        return;
      }
  
      results.forEach(car => {
        const carInfo = `
          <div class="result">
            <p><strong>Make:</strong> ${car.make}</p>
            <p><strong>Model:</strong> ${car.model}</p>
            <p><strong>Year:</strong> ${car.year}</p>
            <p><strong>Location:</strong> ${car.location}</p>
          </div>
        `;
        searchResults.insertAdjacentHTML("beforeend", carInfo);
      });
    }
  });
  
  