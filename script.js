document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('nivelS1Inicial').addEventListener('change', calcularYMostrarCostes);
    document.getElementById('nivelS1Final').addEventListener('change', calcularYMostrarCostes);
    document.getElementById('nivelS2Inicial').addEventListener('change', calcularYMostrarCostes);
    document.getElementById('nivelS2Final').addEventListener('change', calcularYMostrarCostes);
    document.getElementById('nivelS3Inicial').addEventListener('change', calcularYMostrarCostes);
    document.getElementById('nivelS3Final').addEventListener('change', calcularYMostrarCostes);

    document.getElementById('AwakeningInicial').addEventListener('change', function () {
        const nivelAwakeningInicio = parseInt(this.value, 10);
        const contenedorEstrellasInicio = document.getElementById('imgAwakeningInicial');

        contenedorEstrellasInicio.innerHTML = '';

        for (let i = 0; i < nivelAwakeningInicio; i++) {
            const starImgInicio = document.createElement('img');
            starImgInicio.src = "img/cm_icon_star_j.png";
            starImgInicio.alt = "Estrella de awakening activa";
            starImgInicio.style.width = "25px";
            starImgInicio.style.height = "25px";
            contenedorEstrellasInicio.appendChild(starImgInicio);
        }

        for (let i = nivelAwakeningInicio; i < 6; i++) {
            const starImgInactive = document.createElement('img');
            starImgInactive.src = "img/cm_icon_star.png";
            starImgInactive.alt = "Estrella de awakening inactiva";
            starImgInactive.style.width = "25px";
            starImgInactive.style.height = "25px";
            contenedorEstrellasInicio.appendChild(starImgInactive);
        }
        actualizarTotales()
    });
    document.getElementById('AwakeningFinal').addEventListener('change', function () {
        const nivelAwakeningFinal = parseInt(this.value, 10);
        const contenedorEstrellasFinal = document.getElementById('imgAwakeningFinal');

        contenedorEstrellasFinal.innerHTML = '';

        for (let i = 0; i < nivelAwakeningFinal; i++) {
            const starImgFinal = document.createElement('img');
            starImgFinal.src = "img/cm_icon_star_j.png";
            starImgFinal.alt = "Estrella de awakening activa";
            starImgFinal.style.width = "25px";
            starImgFinal.style.height = "25px";
            contenedorEstrellasFinal.appendChild(starImgFinal);
        }

        for (let i = nivelAwakeningFinal; i < 6; i++) {
            const starImgInactiveFinal = document.createElement('img');
            starImgInactiveFinal.src = "img/cm_icon_star.png";
            starImgInactiveFinal.alt = "Estrella de awakening inactiva";
            starImgInactiveFinal.style.width = "25px";
            starImgInactiveFinal.style.height = "25px";
            contenedorEstrellasFinal.appendChild(starImgInactiveFinal);
        }
        actualizarTotales()
    });

    fetch('data.json')
        .then(response => response.json())
        .then(personajes => {
            personajes.sort((a, b) => a.nombre.localeCompare(b.nombre));

            const selectorPersonaje = document.getElementById('selectorPersonaje');
            personajes.forEach(personaje => {
                const opcion = document.createElement('option');
                opcion.value = personaje.nombre;
                opcion.textContent = personaje.nombre;
                selectorPersonaje.appendChild(opcion);
            });
        })
        .catch(error => console.error('Error al cargar los personajes:', error));

    let enhancementsCountS1, enhancementsCountS2, enhancementsCountS3;

    document.getElementById('selectorPersonaje').addEventListener('change', function () {
        const nombrePersonajeSeleccionado = this.value;
        const nombre = this.value;
        document.getElementById('nombrePersonaje').textContent = nombre;

        const contenedorEstrellas = document.getElementById('contenedorEstrellas');
        contenedorEstrellas.innerHTML = '';

        const imgPersonaje = document.getElementById('personaje-img');
        const imgHoroscopo = document.getElementById('horoscopo-img');
        const imgElemento = document.getElementById('elemento-img');
        const imgClase = document.getElementById('clase-img');
        const imgS1 = document.getElementById('imgS1');
        const imgS2 = document.getElementById('imgS2');
        const imgS3 = document.getElementById('imgS3');
        const imgMatSkill = document.getElementById('imgMatSkill');
        const imgMatMax = document.getElementById('imgMatMax');
        const imgRunaMenor = document.getElementById('imgRunaMenor');
        const imgRunaMedia = document.getElementById('imgRunaMedia');
        const imgRunaMayor = document.getElementById('imgRunaMayor');
        const imgMatMax2 = document.getElementById('imgMatMax2');
        const imgMatAwakening = document.getElementById('imgMatAwakening');
        const imgMolagora = document.getElementById('imgMolagora');
        const imgOro = document.getElementById('imgOro');
        const textoClase = document.getElementById('clase-info');
        const textoElemento = document.getElementById('elemento-info');
        const textoHoroscopo = document.getElementById('horoscopo-info');

        fetch('data.json')
            .then(response => response.json())
            .then(personajes => {
                const personajeSeleccionado = personajes.find(p => p.nombre === nombre);
                if (personajeSeleccionado) {
                    imgPersonaje.src = personajeSeleccionado.imagen;
                    imgS1.src = personajeSeleccionado.s1
                    imgS2.src = personajeSeleccionado.s2
                    imgS3.src = personajeSeleccionado.s3

                    imgMolagora.src = "level/ma_moragora1.png"
                    imgOro.src = "img/token_gold.png"
                    textoClase.textContent = personajeSeleccionado.clase
                    textoElemento.textContent = personajeSeleccionado.elemento
                    enhancementsCountS1 = personajeSeleccionado.enhancements_countS1;
                    enhancementsCountS2 = personajeSeleccionado.enhancements_countS2;
                    enhancementsCountS3 = personajeSeleccionado.enhancements_countS3;
                    if (personajeSeleccionado.rareza === 3) {
                        imgMolagora.src = "img/token_stigma.png"
                    } else {
                        imgMolagora.src = "level/ma_moragora1.png"
                    }

                    for (let i = 0; i < personajeSeleccionado.rareza; i++) {
                        contenedorEstrellas.innerHTML += `
                                              <div class="col-auto px-1">
                                                <img src="img/cm_icon_star.png" style="width: 25px; height: 25px;">
                                              </div>`;
                    }

                    fetch('horoscopo.json')
                        .then(response => response.json())
                        .then(horoscopo => {
                            const horoscopoSeleccionado = horoscopo.find(h => h.id === personajeSeleccionado.horoscopo);
                            if (horoscopoSeleccionado) {
                                imgHoroscopo.src = horoscopoSeleccionado.imgHoroscopo;
                                imgMatMax.src = horoscopoSeleccionado.materialMax;
                                imgMatMax2.src = horoscopoSeleccionado.materialMax;
                                imgMatSkill.src = horoscopoSeleccionado.materialSkill;
                                imgMatAwakening.src = horoscopoSeleccionado.materialAwakening;
                                textoHoroscopo.textContent = horoscopoSeleccionado.nombre;
                            }
                        })
                        .catch(error => console.error('Error al cargar el horóscopo:', error));

                    let rutaImagenElemento = '';
                    if (personajeSeleccionado.elemento === 'Agua') {
                        rutaImagenElemento = 'img/cm_icon_promice.png';
                    } else if (personajeSeleccionado.elemento === 'Fuego') {
                        rutaImagenElemento = 'img/cm_icon_promfire.png';
                    } else if (personajeSeleccionado.elemento === 'Tierra') {
                        rutaImagenElemento = 'img/cm_icon_promwind.png';
                    } else if (personajeSeleccionado.elemento === 'Luz') {
                        rutaImagenElemento = 'img/cm_icon_promlight.png';
                    } else if (personajeSeleccionado.elemento === 'Oscuridad') {
                        rutaImagenElemento = 'img/cm_icon_promdark.png';
                    }

                    let rutaImagenClase = '';
                    if (personajeSeleccionado.clase === 'Texere') {
                        rutaImagenClase = 'clase/cm_icon_role_manauser_b.png';
                    } else if (personajeSeleccionado.clase === 'Magus') {
                        rutaImagenClase = 'clase/cm_icon_role_mage_b.png';
                    } else if (personajeSeleccionado.clase === 'Custodes') {
                        rutaImagenClase = 'clase/cm_icon_role_knight_b.png';
                    } else if (personajeSeleccionado.clase === 'Luctor') {
                        rutaImagenClase = 'clase/cm_icon_role_warrior_b.png';
                    } else if (personajeSeleccionado.clase === 'Sagitta') {
                        rutaImagenClase = 'clase/cm_icon_role_ranger_b.png';
                    } else if (personajeSeleccionado.clase === 'Furari') {
                        rutaImagenClase = 'clase/cm_icon_role_assassin_b.png';
                    }
                    let rutaRunasAwakening1 = '';
                    if (personajeSeleccionado.elemento === 'Agua') {
                        rutaRunasAwakening1 = 'level/ma_runeice1.png';
                    } else if (personajeSeleccionado.elemento === 'Fuego') {
                        rutaRunasAwakening1 = 'level/ma_runefire1.png';
                    } else if (personajeSeleccionado.elemento === 'Tierra') {
                        rutaRunasAwakening1 = 'level/ma_runewind1.png';
                    } else if (personajeSeleccionado.elemento === 'Luz') {
                        rutaRunasAwakening1 = 'level/ma_runelight1.png';
                    } else if (personajeSeleccionado.elemento === 'Oscuridad') {
                        rutaRunasAwakening1 = 'level/ma_runedark1.png';
                    }
                    let rutaRunasAwakening2 = '';
                    if (personajeSeleccionado.elemento === 'Agua') {
                        rutaRunasAwakening2 = 'level/ma_runeice2.png';
                    } else if (personajeSeleccionado.elemento === 'Fuego') {
                        rutaRunasAwakening2 = 'level/ma_runefire2.png';
                    } else if (personajeSeleccionado.elemento === 'Tierra') {
                        rutaRunasAwakening2 = 'level/ma_runewind2.png';
                    } else if (personajeSeleccionado.elemento === 'Luz') {
                        rutaRunasAwakening2 = 'level/ma_runelight2.png';
                    } else if (personajeSeleccionado.elemento === 'Oscuridad') {
                        rutaRunasAwakening2 = 'level/ma_runedark2.png';
                    }
                    let rutaRunasAwakening3 = '';
                    if (personajeSeleccionado.elemento === 'Agua') {
                        rutaRunasAwakening3 = 'level/ma_runeice3.png';
                    } else if (personajeSeleccionado.elemento === 'Fuego') {
                        rutaRunasAwakening3 = 'level/ma_runefire3.png';
                    } else if (personajeSeleccionado.elemento === 'Tierra') {
                        rutaRunasAwakening3 = 'level/ma_runewind3.png';
                    } else if (personajeSeleccionado.elemento === 'Luz') {
                        rutaRunasAwakening3 = 'level/ma_runelight3.png';
                    } else if (personajeSeleccionado.elemento === 'Oscuridad') {
                        rutaRunasAwakening3 = 'level/ma_runedark3.png';
                    }

                    imgElemento.src = rutaImagenElemento;
                    imgClase.src = rutaImagenClase;
                    imgRunaMenor.src = rutaRunasAwakening1;
                    imgRunaMedia.src = rutaRunasAwakening2;
                    imgRunaMayor.src = rutaRunasAwakening3;
                    actualizarTotales(personajeSeleccionado.rareza);
                    personajeSeleccionadoCounts = {
                        S1: personajeSeleccionado.enhancements_countS1,
                        S2: personajeSeleccionado.enhancements_countS2,
                        S3: personajeSeleccionado.enhancements_countS3
                    };
                    selectorStigma = personajeSeleccionado.stigma
                    // Cargar las opciones de nivel basadas en enhancements_count para cada habilidad
                    actualizarSelectoresDeNiveles(personajeSeleccionado, 'S1');
                    actualizarSelectoresDeNiveles(personajeSeleccionado, 'S2');
                    actualizarSelectoresDeNiveles(personajeSeleccionado, 'S3');
                } else {
                    imgPersonaje.src = '';
                    imgHoroscopo.src = '';
                    imgElemento.src = '';
                    imgClase.src = '';
                }
            })
            .catch(error => console.error('Error al cargar los personajes:', error));
    });
    let rarezaPersonaje;
    function actualizarSelectoresDeNiveles(personaje, skill) {
        const enhancementsCount = personaje[`enhancements_count${skill}`];
        const selectorInicial = document.getElementById(`nivel${skill}Inicial`);
        const selectorFinal = document.getElementById(`nivel${skill}Final`);

        selectorInicial.innerHTML = '<option value="0">0</option>'; // Incluye 0 como opción válida
        selectorFinal.innerHTML = '<option>Elige un nivel</option>';

        for (let i = 1; i <= enhancementsCount; i++) {
            selectorInicial.innerHTML += `<option value="${i}">${i}</option>`;
            selectorFinal.innerHTML += `<option value="${i}">${i}</option>`;
        }
    }
    function calcularYMostrarCostes() {
        // Reiniciar totales

        if (selectorStigma === 0) {
            let totalMolagora = 0, totalMaterialSkill = 0, totalMaterialMax = 0, totalOro = 0;
            fetch('skills_group.json')
                .then(response => response.json())
                .then(data => {
                    const grupos = ['S1', 'S2', 'S3'].map(skill => personajeSeleccionadoCounts[skill].toString());

                    grupos.forEach((grupo, index) => {
                        const habilidadesGrupo = data[grupo];
                        if (!habilidadesGrupo) {
                            console.error(`No se encontraron datos para el grupo de habilidades: ${grupo}`);
                            return;
                        }

                        const skill = ['S1', 'S2', 'S3'][index];
                        const nivelInicial = parseInt(document.getElementById(`nivel${skill}Inicial`).value, 10);
                        const nivelFinal = parseInt(document.getElementById(`nivel${skill}Final`).value, 10);

                        if (nivelInicial <= nivelFinal) {
                            habilidadesGrupo.filter(habilidad => habilidad.lv > nivelInicial && habilidad.lv <= nivelFinal)
                                .forEach(habilidad => {
                                    totalMolagora += habilidad.molagora;
                                    totalMaterialSkill += habilidad.materialSkill;
                                    totalMaterialMax += habilidad.materialMax;
                                    totalOro += habilidad.oro;
                                });
                        }
                    });

                    document.getElementById('costeMolagora').textContent = `${totalMolagora}`;
                    document.getElementById('costeMatSkill').textContent = `${totalMaterialSkill}`;
                    document.getElementById('costeMatMax').textContent = `${totalMaterialMax}`;
                    document.getElementById('costeOro').textContent = `${totalOro}`;
                })
                .catch(error => console.error('Error al cargar los datos de habilidades:', error));
        } else {
            let totalStigma = 0, totalMaterialSkill = 0, totalMaterialMax = 0, totalOro = 0;
            fetch('skills_groupStigma.json')
                .then(response => response.json())
                .then(data => {
                    const grupos = ['S1', 'S2', 'S3'].map(skill => personajeSeleccionadoCounts[skill].toString());

                    grupos.forEach((grupo, index) => {
                        const habilidadesGrupo = data[grupo];
                        if (!habilidadesGrupo) {
                            console.error(`No se encontraron datos para el grupo de habilidades: ${grupo}`);
                            return;
                        }

                        const skill = ['S1', 'S2', 'S3'][index];
                        const nivelInicial = parseInt(document.getElementById(`nivel${skill}Inicial`).value, 10);
                        const nivelFinal = parseInt(document.getElementById(`nivel${skill}Final`).value, 10);

                        if (nivelInicial <= nivelFinal) {
                            habilidadesGrupo.filter(habilidad => habilidad.lv > nivelInicial && habilidad.lv <= nivelFinal)
                                .forEach(habilidad => {
                                    totalStigma += habilidad.stigma;
                                    totalMaterialSkill += habilidad.materialSkill;
                                    totalMaterialMax += habilidad.materialMax;
                                    totalOro += habilidad.oro;
                                });
                        }
                    });

                    document.getElementById('costeMolagora').textContent = `${totalStigma}`;
                    document.getElementById('costeMatSkill').textContent = `${totalMaterialSkill}`;
                    document.getElementById('costeMatMax').textContent = `${totalMaterialMax}`;
                    document.getElementById('costeOro').textContent = `${totalOro}`;
                })
                .catch(error => console.error('Error al cargar los datos de habilidades:', error));
        }

    }
    function obtenerRareza() {
        const nombrePersonajeSeleccionado = document.getElementById('selectorPersonaje').value;

        fetch('data.json')
            .then(response => response.json())
            .then(personajes => {
                const personaje = personajes.find(p => p.nombre === nombrePersonajeSeleccionado);
                if (personaje) {
                    rarezaPersonaje = personaje.rareza;
                } else {
                    console.error('Personaje no encontrado');
                }
            })
            .catch(error => console.error('Error al cargar los personajes:', error));
    }
    function actualizarTotales() {
        obtenerRareza();

        if (!rarezaPersonaje) {
            console.error('La rareza del personaje no está definida aún');
            return;
        }

        const inicial = parseInt(document.getElementById('AwakeningInicial').value, 10);
        const final = parseInt(document.getElementById('AwakeningFinal').value, 10);

        fetch('awakening.json')
            .then(response => response.json())
            .then(data => {
                const rangos = data[rarezaPersonaje].filter(item => item.id > inicial && item.id <= final);

                const totales = rangos.reduce((acc, cur) => {
                    acc.gemaslv1 += cur.gemaslv1;
                    acc.gemaslv2 += cur.gemaslv2;
                    acc.gemaslv3 += cur.gemaslv3;
                    acc.awakening += cur.awakening;
                    acc.matMax += cur.matMax;
                    return acc;
                }, {gemaslv1: 0, gemaslv2: 0, gemaslv3: 0, awakening: 0, matMax: 0});

                document.getElementById('totalGemasLv1').textContent = `${totales.gemaslv1}`;
                document.getElementById('totalGemasLv2').textContent = `${totales.gemaslv2}`;
                document.getElementById('totalGemasLv3').textContent = `${totales.gemaslv3}`;
                document.getElementById('totalAwakening').textContent = `${totales.awakening}`;
                document.getElementById('totalMatMax').textContent = `${totales.matMax}`;
            })
            .catch(error => console.error('Error al cargar los datos de awakening:', error));
    }
});
