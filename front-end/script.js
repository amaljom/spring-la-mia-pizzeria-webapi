fetch('http://localhost:8080/api/1/penna/all')
    .then((response) => response.json())
    .then((data) => console.log(data));
