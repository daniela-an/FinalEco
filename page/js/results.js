window.addEventListener('load', e => {
    var TOTAL = 0;

    setListener('votes', obj => {
        games_vals.innerHTML = '';
        TOTAL = 0;

        for (const key in obj) {
            console.log(obj[key])
            if ( obj.hasOwnProperty(key) ) TOTAL += Object.values(obj[key]).length;
        }

        total_votes.innerText = `Total de votos: ${TOTAL}`;
        
        for (const key in obj) {
            if (obj.hasOwnProperty(key)) {
                p = document.createElement('p')
                p.innerText = `${key} ( ${ ( Math.round( (Object.values(obj[key]).length / TOTAL) * 100) )} %)`;
                games_vals.appendChild(p)
            }
        }

    })
});