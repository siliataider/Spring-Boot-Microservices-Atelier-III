
let userTemplate = document.querySelector("#user");
function getUserName() {
    var token = localStorage.getItem('userToken');
    var tokenUser = JSON.parse(atob(token.split('.')[1]));
    let clone = document.importNode(userTemplate.content, true);
    newContent= clone.firstElementChild.innerHTML
        .replace(/{{user_name}}/g, tokenUser.sub)
        .replace(/{{user_money}}/g, tokenUser.money)
    clone.firstElementChild.innerHTML= newContent;
    document.getElementById("user-info").appendChild(clone);
}

function getSellList() {
    getUserName();
    var token = localStorage.getItem('userToken');
    var tokenUser = JSON.parse(atob(token.split('.')[1]));
    const POST_URL="http://localhost:8082/sell/user/"+tokenUser.id;
    let context =   {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json',
            'Authorization': `Bearer ${localStorage.getItem('userToken')}`
        },
    };

    fetch(POST_URL,context)
        .then(response => callbackBuy(response))
        .catch(error => err_callback(error));

}
let template = document.querySelector("#row");

function callbackBuy(response){
    response.json().then(cards => cards.forEach(card => {
        renderCard(card);
    }))
}


function renderCard(card) {
    let clone = document.importNode(template.content, true);
    newContent= clone.firstElementChild.innerHTML
        .replace(/{{family_src}}/g, card.family_src)
        .replace(/{{family_name}}/g, card.family_name)
        .replace(/{{img_src}}/g, card.img_src)
        .replace(/{{name}}/g, card.name)
        .replace(/{{description}}/g, card.description)
        .replace(/{{hp}}/g, card.hp)
        .replace(/{{energy}}/g, card.energy)
        .replace(/{{attack}}/g, card.attack)
        .replace(/{{defense}}/g, card.defense)
        .replace(/{{price}}/g, card.price)
        .replace(/sellCard\(id\)/g, `sellCard(${card.id})`);
    clone.firstElementChild.innerHTML= newContent;

    let cardContainer= document.querySelector("#tableContent");
    cardContainer.appendChild(clone);
}

function sellCard(cardId) {
    var token = localStorage.getItem('userToken');
    var tokenUser = JSON.parse(atob(token.split('.')[1]));
    const POST_URL=`http://localhost:8082/sell/${cardId}/user/${tokenUser.id}`;
    let context =   {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Accept': 'application/json',
            'Authorization': `Bearer ${localStorage.getItem('userToken')}`,
        }
    };

    fetch(POST_URL,context)
        .catch(error => err_callback(error));
}






