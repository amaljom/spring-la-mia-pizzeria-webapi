fetch('http://localhost:8080/api/1/penna/all')
    .then((response) => response.json())
    .then((data) => console.log(data));
    
fetch('http://localhost:8080/api/1/pizza/all')
    .then((response) => response.json())
    .then((data) => console.log(data));
