import { useState } from 'react';
import { GridContainer, MainContent, SectionTitle, StreamGrid} from './styles';
import Header from '../../components/Header';
import Sidebar from '../../components/Sidebar';
import StreamCard from '../../components/StreamCard';
import Banner from "../../components/Banner/index.jsx";
import LoginModal from "../../components/LoginModal/index.jsx";

export default function Home() {

    const [modalTab, setModalTab] = useState(null);

    const livesJogos = [
        { id: 1, streamer: "PaulinhoLokobr", titulo: "PAULÓPOLIS VAI INAUGURAR!!!", visualizadores: "1.5K", categoria: "GTA VI", print: "./livePaulinho.webp", avatar: "./avatarPaulinho.webp" },
        { id: 2, streamer: "Pelegrino1993", titulo: "DIA 251 | FIFINHA RENASCEU", visualizadores: "4.2K", categoria: "EA Sports FC 26", print: "./printPelegrino.webp", avatar: "./avatarPelegrino.webp" },
        { id: 3, streamer: "Gaules", titulo: "NRG X BIG | IEM Cologne Major 2026", visualizadores: "7.712", categoria: "Counter-Strike 2", print: "./printGaules.webp", avatar: "./avatarGaules.webp" },
        { id: 4, streamer: "titanlol", titulo: "TOP 1 MAIS PROXIMO QUE NUNCA", visualizadores: "1.4K", categoria: "League of Legends", print: "./printTitanlou.webp", avatar: "./avatarTitanlou.webp" },
    ];

    const livesCod = [
        { id: 1, streamer: "N4noFPS", titulo: "EM BUSCA DO TOP 2", visualizadores: "38", categoria: "Call of Duty: Warzone", print: "./printN4nofps.webp", avatar: "./avatarN4nofps.webp" },
        { id: 2, streamer: "NGVieira", titulo: "CAMPEONATO de WARZONE", visualizadores: "37", categoria: "Call of Duty: Warzone", print: "./printNGVieira.webp", avatar: "./avatarNGVieira.webp" },
        { id: 3, streamer: "pedroox2", titulo: "Sextouu!!", visualizadores: "22", categoria: "Call of Duty: Warzone", print: "./printPedroox2.webp", avatar: "./avatarPedroox2.webp" },
        { id: 4, streamer: "Yanzinxl07", titulo: "bora que bora - KICK PARTNER", visualizadores: "11", categoria: "Call of Duty: Warzone", print: "./printYanzin.webp", avatar: "./avatarYanzin.webp" },
    ];

    const livesFortnite = [
        { id: 1, streamer: "JulietaRochaRP", titulo: "✅ KICK PARTNER ✅", visualizadores: "250", categoria: "Fortnite", print: "./printJulieta.webp", avatar: "./avatarJulieta.webp" },
        { id: 2, streamer: "Lucasgamestv", titulo: "🔥 AO VIVO NA Kick", visualizadores: "211", categoria: "Fortnite", print: "./printLucas.webp", avatar: "./avatarLucas.webp" },
        { id: 3, streamer: "Dkzera", titulo: "🎮 Fortnite AO VIVO | Jogando com Inscritos", visualizadores: "77", categoria: "Fortnite", print: "./printDkzera.webp", avatar: "./avatarDkzera.webp" },
        { id: 4, streamer: "TioZangado", titulo: "JOGANDO FORTNITE", visualizadores: "6", categoria: "Fortnite", print: "./printTioZangado.webp", avatar: "./avatarTioZangado.webp" },
    ];

    return (
        <GridContainer>
            <Header onLoginClick={() => setModalTab('entrar')}
            onRegisterClick={() => setModalTab('cadastrar')}
            />
            <Sidebar />
            <MainContent>
                <Banner />

                <section style={{ display: "flex", flexDirection: "column" }}>
                    <SectionTitle>Jogos</SectionTitle>
                        <StreamGrid>
                            {livesJogos.map(live => (

                                <StreamCard

                                    key={live.id}
                                    streamer={live.streamer}
                                    titulo={live.titulo}
                                    visualizadores={live.visualizadores}
                                    categoria={live.categoria}
                                    print={live.print}
                                    avatar={live.avatar}
                                />
                            ))}
                        </StreamGrid>
                </section>
                <section style={{ display: "flex", flexDirection: "column" }}>
                    <SectionTitle>Call of Duty</SectionTitle>
                        <StreamGrid>
                            {livesCod.map(live => (
                                <StreamCard
                                    key={live.id}
                                    streamer={live.streamer}
                                    titulo={live.titulo}
                                    visualizadores={live.visualizadores}
                                    categoria={live.categoria}
                                    print={live.print}
                                    avatar={live.avatar}
                                />
                            ))}
                        </StreamGrid>
                </section>
                <section style={{ display: "flex", flexDirection: "column" }}>
                    <SectionTitle>Fortnite</SectionTitle>
                        <StreamGrid>
                            {livesFortnite.map(live => (
                                <StreamCard
                                    key={live.id}
                                    streamer={live.streamer}
                                    titulo={live.titulo}
                                    visualizadores={live.visualizadores}
                                    categoria={live.categoria}
                                    print={live.print}
                                    avatar={live.avatar}
                                />
                            ))}
                        </StreamGrid>
                </section>
            </MainContent>

            {modalTab && (
                <LoginModal
                    initialTab={modalTab}
                    onClose={() => setModalTab(null)}
                />
            )}
        </GridContainer>
    );
}