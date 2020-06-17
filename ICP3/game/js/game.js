const result_msg = document.querySelector('.result_msg');
const score = document.querySelector('.res');
const but = document.querySelectorAll('button');
const resul = [0,0];

//add events
for ( let i = 0 ; i < but.length ; i++){
    but[i].addEventListener('click', play);
}

function play(s){
    //player selection
    let pSelection = s.target.innerText;
    // computer selection
    let cSelection = Math.random();

    //if computerSelection is less than .34, computer selects Rock
    if (cSelection < .34){
        cSelection = 'Rock';
    } else if (cSelection <= .67){
        cSelection = 'Paper';
    } else {
        cSelection = 'Scissors';
    }

    //compare selections and give result
    let result = Winner(pSelection, cSelection);

    //output scores to the DOM
    if (result === 'Player'){
        result += ' wins';
        //update score
        resul[0]++;
    }

    if (result === 'Computer'){
        result += ' wins';
        resul[1]++;
    }

    if (result === 'equal'){
        result += '. equality between player and computer'
    }

    //output score into Score DIV
    score.innerHTML = 'Player: [ ' + resul[0]+ ' ] Computer: [ ' + resul[1] + ' ]';

    //output player and computer's selections
    mess('Player: <strong>' + pSelection + '</strong> Computer: <strong>' + cSelection + '</strong><br>' + result);
}

function mess(sMessage){
    result_msg.innerHTML = sMessage;
}

function Winner(p, c){
    if (p === c){
        return 'equal';
    }

    if (p === 'Rock'){
        if(c === 'Paper'){
            return 'Computer';
        } else {
            return 'Player';
        }
    }

    if (p === 'Paper'){
        if (c === 'Scissors'){
            return 'Computer';
        } else {
            return 'Player';
        }
    }

    if (p === 'Scissors'){
        if (c === 'Rock'){
            return 'Computer';
        } else {
            return 'Player';
        }
    }
}