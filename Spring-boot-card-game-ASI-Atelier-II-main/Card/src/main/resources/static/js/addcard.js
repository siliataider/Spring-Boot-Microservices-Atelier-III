function handleSubmit(){

    let form = document.getElementById("formCard");
    let data = new FormData(form);

    const value = Object.fromEntries(data.entries());

    console.log({value});

    sendCard(value);


}

function sendCard(data){

    const POST_URL="http://localhost:8081/hero";
    let context =   {
                        method: 'POST',
                        headers: {
                            'Content-Type': 'application/json',
                            'Accept': 'application/json',
                        },
                        body: JSON.stringify(data),
                    };
        
    fetch(POST_URL,context)
            .then(response => callback(response))
            .catch(error => err_callback(error));
}

function callback(response){
    console.log(response.value);
}

function err_callback(error){
    console.log(error);
}
