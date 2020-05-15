window.addEventListener('load', e => {
    var TOTAL = 0;

    setListener('votes', obj => {
        games_vals.innerHTML = '';
        TOTAL = 0;

        for (const key in obj) {
            if ( obj.hasOwnProperty(key) ) { 
                TOTAL += Object.values(obj[key]).length;
                obj[key] = Object.values(obj[key]).length;
            }
        }

        total_votes.innerText = `Total de votos: ${TOTAL}`;
        
        for (const key in obj) {
            if (obj.hasOwnProperty(key)) {
                p = document.createElement('p')
                p.innerText = `${key} ( ${ ( Math.round( (obj[key] / TOTAL) * 100) )} %)`;
                games_vals.appendChild(p)
            }
        }
        console.log(obj)
        var borderColors = [ 'rgba(255, 99, 132, 1)', 'rgba(54, 162, 235, 1)', 'rgba(255, 206, 86, 1)', 'rgba(75, 192, 192, 1)','rgba(153, 102, 255, 1)', 'rgba(255, 159, 64, 1)'];
        var backgroundColors = ['rgba(255, 99, 132, 0.2)', 'rgba(54, 162, 235, 0.2)', 'rgba(255, 206, 86, 0.2)', 'rgba(75, 192, 192, 0.2)', 'rgba(153, 102, 255, 0.2)', 'rgba(255, 159, 64, 0.2)' ];
        var ctx = document.getElementById('myChart');
        var myChart = new Chart(ctx, {
            type: 'bar',
            data: {
                labels: Object.keys(obj),
                datasets: [{
                    label: 'Recuento de votos',
                    data: Object.values(obj),
                    backgroundColor: backgroundColors,
                    borderColor: borderColors,
                    borderWidth: 1
                }]
            },
            options: {
                scales: {
                    yAxes: [{
                        ticks: {
                            beginAtZero: true
                        }
                    }]
                }
            }
        });

        var ctx = document.getElementById('myChart2');
        var myDoughnutChart = new Chart(ctx, {
            type: 'doughnut',
            data: {
                labels: Object.keys(obj),
                datasets: [{
                    label: 'Recuento de votos',
                    data: Object.values(obj),
                    backgroundColor: backgroundColors,
                    borderColor: borderColors
                }]
            },
            options: {
                scales: {
                    yAxes: [{
                        ticks: {
                            beginAtZero: true
                        }
                    }]
                }
            }
        });
    });

    
});