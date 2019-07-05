$(() => {
    $('form').submit(event => {
        event.preventDefault();
        let $form = $( event.target );
        let url = $form.attr( "action" );
        let formData = $form.serializeObject();

        $('#result').load(url, formData);
    } )
});

jQuery.fn.serializeObject = function() {
    let $form = $(this);
    let formdata = $form.serializeArray();
    let data = {};
    formdata.map(obj => data[obj.name] = obj.value);
    return data;
};