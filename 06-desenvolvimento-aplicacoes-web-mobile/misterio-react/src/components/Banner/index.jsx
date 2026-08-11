import React from 'react';
import {
    BannerContainer, VideoSection, LiveIndicator, VideoFooter,
    StreamerInfo, AssistirBtn, ChatSection, ChatHeader, ChatMessage, StreamerDetail, FooterBtn,
    StreamerDescription, StreamerTitle, ButtonSeta
} from './styles';

export default function Banner() {
    return (
        <BannerContainer>
            {/* Lado Esquerdo: A Transmissão de Destaque */}
            <VideoSection image="./printAlanzoka.jpg">
                <LiveIndicator>861</LiveIndicator>

                <VideoFooter>
                    <StreamerInfo>
                        <StreamerDetail>
                        <img src='../avatarAlanzoka.jpg' alt="Alanzoka" />
                            <StreamerDescription>
                            <h3>Alanzoka</h3>
                            <StreamerTitle>
                            <p>Kingdom Come...</p>
                            <h4>Kingdom Comes Deliverance 2</h4>
                            </StreamerTitle>
                            </StreamerDescription>
                        </StreamerDetail>
                    <FooterBtn>
                        <AssistirBtn>Assistir Agora</AssistirBtn>
                        <div className="setasNavegacao">
                        <ButtonSeta>⬅</ButtonSeta>
                        <ButtonSeta>➡</ButtonSeta>
                        </div>
                    </FooterBtn>
                    </StreamerInfo>
                </VideoFooter>
            </VideoSection>

            {/* Lado Direito: O Chat Lateral */}
            <ChatSection>
                <ChatHeader>💬 Chat da Transmissão</ChatHeader>
                <ChatMessage><strong>JPSantos_ON:</strong> começar aqui a minha</ChatMessage>
                <ChatMessage><strong>danieloli1999:</strong> Pele ea removeu ver adversários</ChatMessage>
                <ChatMessage><strong>viana013:</strong> clima ruim n cara ...</ChatMessage>
                <ChatMessage><strong>ely_ferreira:</strong> Jogo pende demais para um lado pqp!</ChatMessage>
            </ChatSection>
        </BannerContainer>
    );
}