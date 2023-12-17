function converterCoordenadas(x, y) {
    // Escala para converter as coordenadas recebidas para o novo sistema
    const escalaX = 15360 / 256;
    const escalaY = 15360 / 256;

    // Converte as coordenadas
    let novoX = x / escalaX;
    // Inverte o eixo Y e ajusta de acordo com o novo sistema
    let novoY = (y / escalaY - 256);

    return [novoY, novoX];
}