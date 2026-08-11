import styled from 'styled-components';

export const CardContainer = styled.div`
    display: flex;
    flex-direction: column;
    cursor: pointer;
    width: 100%;

  &:hover img {
    transform: scale(1.02);
  }
`;

export const ThumbWrapper = styled.div`
    position: relative;
    width: 100%;
    aspect-ratio: 16 / 9;
    border-radius: 8px;
    overflow: hidden;
    background-color: #191b1f;
`;

export const Thumbnail = styled.img`
    width: 100%;
    height: 100%;
    object-fit: cover;
    transition: transform 0.2s ease;
`;

export const LiveBadge = styled.span`
    position: absolute;
    top: 10px;
    left: 10px;
    background-color: #ea1f1f;
    color: #fff;
    padding: 2px 6px;
    font-size: 11px;
    font-weight: 700;
    border-radius: 4px;
    text-transform: uppercase;
`;

export const ViewersCount = styled.span`
    position: absolute;
    bottom: 10px;
    left: 10px;
    background-color: rgba(0, 0, 0, 0.75);
    color: #fff;
    padding: 2px 6px;
    font-size: 11px;
    font-weight: 600;
    border-radius: 4px;
`;

export const CardDetails = styled.div`
    display: flex;
    gap: 12px;
    margin-top: 12px;
`;

export const StreamerAvatar = styled.div`
    width: 36px;
    height: 36px;
    border-radius: 50%;
    background-image: url(${props => props.image});
    background-size: cover;
    background-position: center;
    flex-shrink: 0;
`;

export const TextDetails = styled.div`
    display: flex;
    flex-direction: column;
    overflow: hidden;

  h3 {
    font-size: 14px;
    font-weight: 600;
    color: #fff;
    line-height: 1.3;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
    margin-bottom: 4px;
  }

  h4 {
    font-size: 13px;
    font-weight: 500;
    color: white;
    margin-bottom: 2px;
  }

  p {
    font-size: 12px;
    background-color: #42474D;
      border-radius: 20px;
      padding: 5px 10px;
      width: 100%;
  }
`;