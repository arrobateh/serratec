import {useEffect, useState} from 'react'
import styles from './styles.module.css'

function LoginModal() {

    const [activeTab, setActiveTab] = useState('entrar')
    const [isSubmitted, setSubmitted] = useState(false)
    const [emailOrUser, setEmailOrUser] = useState('');

    const [password, setPassword] = useState('');

    const [userAuthenticated, setUserAuthenticated] = useState(null);

    const handleLogin = (event) => {
        event.preventDefault();

        if (activeTab === 'entrar') {
            if (!emailOrUser || !password) {
                alert('Por favor, preencha todos os campos!');
            } else if (emailOrUser !== userAuthenticated.email || password !== userAuthenticated.password ) {
                alert('Usuário não encontrado!');
            }

        }
        else if (activeTab === 'cadastrar') {
            setUserAuthenticated({
                email: emailOrUser,
                password: password,
            });
            alert('Cadastro realizado com sucesso!');


            setActiveTab('entrar');
        }
        if (activeTab === 'entrar') {
            if (emailOrUser === userAuthenticated.email && password === userAuthenticated.password) {



                setEmailOrUser('');
                setPassword('');
                setSubmitted(true);
            }
        }
    };

    useEffect(() => {
        if(isSubmitted) {
            console.log('Usuário autenticado!');
            console.log('Email do usuário: ', userAuthenticated.email);
            console.log('Senha do usuário: ', userAuthenticated.password);

            alert('Login realizado com sucesso!');

            setSubmitted(false)
        }
    }, [isSubmitted]);

    return (
        <div className={styles.modalOverlay}>
            <div className={styles.loginCard}>
                <div className={styles.logoContainer}>
                    <span className={styles.logoKick}>KICK<span className={styles.betaTag}>BETA</span></span>
                    <button className="close-btn">&times;</button>
                </div>

                <div className="tabs">
                    <button type="button"
                            className={`tab-btn ${activeTab === 'entrar' ? 'active' : ''}`}
                            onClick={() => setActiveTab('entrar')}>Entrar</button>
                    <button type={"button"}
                            className={`tab-btn ${activeTab === 'cadastrar' ? 'active' : ''}`}
                            onClick={() => setActiveTab('cadastrar')}>Cadastrar-se</button>
                </div>

                <form className="login-form" onSubmit={handleLogin}>
                    <div className="input-group">
                        <label htmlFor="username"> {activeTab === 'entrar' ? 'E-mail ou nome de usuário' : 'E-mail'}
                        </label>
                        <input type="text"
                               id="username" autoComplete="off"
                               placeholder={activeTab === 'cadastrar' ? 'you@example.com' : ''}
                            // onChange={(e) => setEmailOrUser(e.target.value)}/>
                               onChange={(e) => setEmailOrUser(e.target.value)}/>
                    </div>
                    {activeTab === 'cadastrar' && (
                        <div className="input-group">
                            <label htmlFor="date">{activeTab === 'cadastrar' ? 'Data de nascimento' : ''}
                            </label>
                            <input type="date"
                                   id="date"
                                   value={new Date().toISOString(). split('T')[0]}></input>
                        </div>
                    )}
                    {activeTab === 'cadastrar' && (
                        <div className="input-group">
                            <label htmlFor="usuario">{activeTab === 'cadastrar' ? 'Usuário' : ''}
                            </label>
                            <input type="text"
                                   id="usuario">
                            </input>
                        </div>
                    )}

                    <div className="input-group">
                        <label htmlFor="password">Senha</label>
                        <div className="password-wrapper">
                            <input type="password"
                                   id="password"
                                   value={password}
                                // onChange={(e) => setPassword(e.target.value)}/>
                                   onChange={(e) => setPassword(e.target.value)}/>
                        </div>
                        {activeTab === 'entrar' && (
                            <a href="#" className="forgot-password">Esqueceu sua senha?</a>
                        )}
                    </div>

                    <button type="submit" className="subimit-btn">Entrar</button>
                </form>

                <div className="divider">
                    <span>ou continue com</span>
                </div>

                <div className="social-login">
                    <button className="social-btn google-btn">
                        <img src="https://upload.wikimedia.org/wikipedia/commons/c/c1/Google_%22G%22_logo.svg"
                             alt="Google"/>
                    </button>
                    <button className="social-btn apple-btn">
                        <img src="https://upload.wikimedia.org/wikipedia/commons/f/fa/Apple_logo_black.svg"
                             alt="Apple"/>
                    </button>
                </div>
            </div>
        </div>
    )
}

export default LoginModal
