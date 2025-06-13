function mostrarFormulario() {
    const tipo = document.getElementById('tipoRecurso').value;
    document.getElementById('formLibro').classList.add('hidden');
    document.getElementById('formPeriodico').classList.add('hidden');
    document.getElementById('formComputador').classList.add('hidden');

    if (tipo === 'Libro') document.getElementById('formLibro').classList.remove('hidden');
    if (tipo === 'Periodico') document.getElementById('formPeriodico').classList.remove('hidden');
    if (tipo === 'Computador') document.getElementById('formComputador').classList.remove('hidden');
}

async function guardarRecurso() {
    const tipo = document.getElementById('tipoRecurso').value;
    const nombre = document.getElementById('nombre').value;
    const fechaIngreso = document.getElementById('fechaIngreso').value;
    const activo = document.getElementById('activo').checked;

    let recurso = { nombre, fechaIngreso, activo };

    if (tipo === 'Libro') {
        recurso = {
            ...recurso,
            autor: document.getElementById('autor').value,
            editorial: document.getElementById('editorialLibro').value,
            anio: document.getElementById('anio').value
        };
    } else if (tipo === 'Periodico') {
        recurso = {
            ...recurso,
            fechaPublicacion: document.getElementById('fechaPublicacion').value,
            editorial: document.getElementById('editorialPeriodico').value
        };
    } else if (tipo === 'Computador') {
        recurso = {
            ...recurso,
            marca: document.getElementById('marca').value,
            modelo: document.getElementById('modelo').value,
            sistemaOperativo: document.getElementById('sistemaOperativo').value,
            tipoComputador: document.getElementById('tipoComputador').value
        };
    }

    const response = await fetch(`/api/${tipo.toLowerCase()}`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(recurso)
    });

    if (response.ok) {
        alert("Recurso guardado correctamente.");
        await cargarRecursos();
    } else {
        alert("Error al guardar el recurso.");
    }
}

async function cargarRecursos() {
    const lista = document.getElementById('listaRecursos');
    lista.innerHTML = '';
    const response = await fetch('/api/recursos');
    const recursos = await response.json();
    let tipo = "";

    recursos.forEach(r => {
        let detalles = `
            <strong>${r.nombre}</strong> (ID: ${r.id || 'Sin ID'})<br>
            Fecha de ingreso: ${r.fechaIngreso || 'No especificado'}<br>
            Activo: ${r.activo ? 'Sí' : 'No'}<br>
        `;

        if (r.autor) {
            detalles += `Autor: ${r.autor}<br>Editorial: ${r.editorial}<br>Año: ${r.anio}<br>`;
            tipo = "libro"
        }
        if (r.fechaPublicacion) {
            detalles += `Fecha publicación: ${r.fechaPublicacion}<br>Editorial: ${r.editorial}<br>`;
            tipo = "periodico"
        }
        if (r.marca) {
            detalles += `Marca: ${r.marca}<br>Modelo: ${r.modelo}<br>SO: ${r.sistemaOperativo}<br>Tipo: ${r.tipoComputador}<br>`;
            tipo = "computador"
        }

        const li = document.createElement('li');
        li.innerHTML = `
            ${detalles}
            <button onclick="eliminarRecurso('${tipo}', ${r.id})">Eliminar</button>

        `;
        lista.appendChild(li);
    });
}

async function eliminarRecurso(tipo,id) {
    if (confirm("¿Seguro que deseas eliminar este recurso?")) {
        const response = await fetch(`/api/recursos/${tipo}/${id}`, { method: 'DELETE' });
        if (response.ok) {
            alert("Recurso eliminado.");
            await cargarRecursos();
        } else {
            alert("Error al eliminar.");
        }
    }
}

async function buscarRecursos() {
    const criterio = document.getElementById('criterioBusqueda').value;
    const lista = document.getElementById('listaRecursos');
    lista.innerHTML = '';
    const response = await fetch(`/api/recursos?criterio=${criterio}`);
    const resultados = await response.json();

    resultados.forEach(r => {
        let detalles = `
            <strong>${r.nombre}</strong> (ID: ${r.id || 'Sin ID'})<br>
            Fecha de ingreso: ${r.fechaIngreso || 'No especificado'}<br>
            Activo: ${r.activo ? 'Sí' : 'No'}<br>
        `;

        let tipo;
        if (r.autor) {
            detalles += `Autor: ${r.autor}<br>Editorial: ${r.editorial}<br>Año: ${r.anio}<br>`;
            tipo = "libro"
        }
        if (r.fechaPublicacion) {
            detalles += `Fecha publicación: ${r.fechaPublicacion}<br>Editorial: ${r.editorial}<br>`;
            tipo = "periodico"
        }
        if (r.marca) {
            detalles += `Marca: ${r.marca}<br>Modelo: ${r.modelo}<br>SO: ${r.sistemaOperativo}<br>Tipo: ${r.tipoComputador}<br>`;
            tipo = "computador"
        }

        const li = document.createElement('li');
        li.innerHTML = `
            ${detalles}
            <button onclick="eliminarRecurso('${tipo}', ${r.id})">Eliminar</button>

        `;
        lista.appendChild(li);
    });
}

window.onload = () => cargarRecursos();