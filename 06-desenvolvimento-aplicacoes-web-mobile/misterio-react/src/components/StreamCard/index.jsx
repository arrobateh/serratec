import { CardContainer, ThumbWrapper, Thumbnail, LiveBadge, ViewersCount, CardDetails, StreamerAvatar, TextDetails } from './styles';

export default function StreamCard({ streamer, titulo, visualizadores, categoria, print, avatar }) {
    return (
        <CardContainer>
            <ThumbWrapper>
                <Thumbnail src={print} alt={titulo} />
                <LiveBadge>Ao Vivo</LiveBadge>
                <ViewersCount>{visualizadores} espect.</ViewersCount>
            </ThumbWrapper>

            <CardDetails>
                <StreamerAvatar image={avatar} />
                <TextDetails>
                    <h4>{streamer}</h4>
                    <h3>{titulo}</h3>
                    <p>{categoria}</p>
                </TextDetails>
            </CardDetails>
        </CardContainer>
    );
}