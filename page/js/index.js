window.addEventListener('load', e => {
    btn_reg.addEventListener('click', e => {
        let name = inp_name.value, studio = inp_estudio.value, year = inp_year.value;
        name && studio && year ?
            writeUserData(name, {name, studio, year}, e => {
                inp_name.value = ''
                inp_estudio.value  = ''
                inp_year.value  = ''

                alert('agregado satisfactoriamente');
            })
        :
            alert('porfavor llene todos los campos');
    })

    div_plays
});