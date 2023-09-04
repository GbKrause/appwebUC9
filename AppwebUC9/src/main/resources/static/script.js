const form = document.getElementById('cadastroForm');
const tabelaPessoas = document.getElementById("tabelaPessoas").getElementsByTagName('tbody')[0];
const btnListarPessoas = document.getElementById("btnListarPessoas");


form.addEventListener("submit", function(event) {
    event.preventDefault();

    let formData = new FormData(form);

    let params = new URLSearchParams(formData);

    let url = "/person?" + params.toString();

    fetch(url, {
        method: "POST"
    })
        .then(response => response.json())
        .then(data => {
            document.getElementById('name').value = data.name;
            document.getElementById('id').value = data.id;
            document.getElementById('sexo').value = data.sexo;
        })
        .catch(error => {
            console.error("Erro ao enviar dados:", error);
        });
});

btnListarPessoas.addEventListener("click", function() {
    fetch("/all")
        .then(response => response.json())
        .then(data => {

            tabelaPessoas.innerHTML = "";

            data.forEach(function (pessoa) {
                let row = tabelaPessoas.insertRow();

                let cellId = row.insertCell(0);
                let cellNome = row.insertCell(1);
                let cellSexo = row.insertCell(2);

                cellId.textContent = pessoa.id;
                cellNome.textContent = pessoa.name;
                cellSexo.textContent = pessoa.sexo;
            });
        })
        .catch(error => {
            console.error("Erro ao obter lista de pessoas:", error);
        });
})