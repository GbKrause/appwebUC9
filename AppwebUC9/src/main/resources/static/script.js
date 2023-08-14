const formPessoa = document.getElementById("cadastroPessoa");
const tabelaPessoa = document.getElementById("tabelaPessoas")
    .getElementsByTagName('tbody')[0];
const btnAll = document.getElementById("listarPessoas");
const btnExcluir = document.getElementById("excluir");

btnAll.addEventListener("click", function (){
    fetch("/all")
        .then(response => response.json())
        .then(data => {

            tabelaPessoa.innerHTML ="";
            data.forEach(pessoa => {
                let row = tabelaPessoa.insertRow();
                row.insertCell(0).textContent = pessoa.id;
                row.insertCell(1).textContent = pessoa.name;
                row.insertCell(2).textContent = pessoa.sexo;
            })
    })

});



formPessoa.addEventListener("submit", function (event){
   event.preventDefault();
    let formDados = new FormData(formPessoa);
    let parametros = new URLSearchParams(formDados);


   fetch("/person?"+parametros.toString(), {
      method: "POST"
   }).then(response => response.json())
       .then(data => {
          document.getElementById("id").value = data.id;


       })

});

btnExcluir.addEventListener("click", function (event){
    event.preventDefault();
    let formDados = new FormData(formPessoa);
    let parametros = new URLSearchParams(formDados);

    fetch("/person?" + parametros.toString(),{
        method: "DELETE"
    }).then(response => {
        if (response.ok){
            console.log("Pessoa removida com sucesso!");
            document.getElementById("id").value = "";
            document.getElementById("nome").value ="";
            document.getElementById("sexo").value = "";
        }else{
            console.error("Erro ao remover pessoa.");
        }
    })
})
