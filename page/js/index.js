window.addEventListener('load', e => {
    btn_reg.addEventListener('click', e => {
        let name = inp_name.value, studio = inp_estudio.value, year = inp_year.value;
        name && studio && year ?
            writeUserData(name.replace(' ', ''), {name, studio, year}, e => {
                inp_name.value = ''
                inp_estudio.value  = ''
                inp_year.value  = ''

                alert('agregado satisfactoriamente');
            })
        :
            alert('porfavor llene todos los campos');
    })

    setListener('juegos', arr => {
        div_plays.innerHTML = '';
        for (const key in arr) {
            if (arr.hasOwnProperty(key)) {
                p = document.createElement('p')
                p.innerText = arr[key].name
                div_plays.appendChild(p)
            }
        }
    })
});