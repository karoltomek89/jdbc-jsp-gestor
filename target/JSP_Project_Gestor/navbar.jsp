<nav class="navbar navbar-expand-xl navbar-dark bg-primary">
    <a class="navbar-brand" href="#">Panel nawigacyjny</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup"
            aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">

            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="start" role="button" data-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">
                    START
                </a>

                <div class="dropdown-menu" aria-labelledby="start">
                    <a class="dropdown-item" data-toggle="modal" data-target="#exampleModal2">Logowanie</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" data-toggle="modal" data-target="#exampleModal1">Rejestracja</a>
                </div>
            </li>

            <!-- Modal -->
            <div class="modal fade" id="exampleModal1" tabindex="-1" role="dialog"
                 aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Panel rejestracji</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">

                            <form>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="inputEmail4">Twój adres e-mail</label>
                                        <input type="email" class="form-control" id="inputEmail4" placeholder="Email">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="inputPassword4">Twoje hasło</label>
                                        <input type="password" class="form-control" id="inputPassword4" placeholder="Hasło">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="inputSchoolName">Nazwa szkoły</label>
                                    <input type="text" class="form-control" id="inputSchoolName" placeholder="Nazwa szkoły">
                                </div>
                                <div class="form-group">
                                    <label>Typ konta</label>
                                    <select class="custom-select">
                                        <option selected>Wybierz typ konta</option>
                                        <option value="1">Uczeń</option>
                                        <option value="2">Nauczyciel</option>
                                        <option value="3">Dyrektor</option>
                                        <option value="4">Rodzic</option>
                                    </select>

                                </div>
                            </form>

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Anuluj</button>
                            <button type="button" class="btn btn-primary">Zarejestruj</button>
                        </div>
                    </div>
                </div>
            </div>





            <!-- Modal -->
            <div class="modal fade" id="exampleModal2" tabindex="-1" role="dialog"
                 aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabe2">Panel logowania</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">

                            <form>
                                <div class="form-group row">
                                    <label for="staticEmail" class="col-4 col-form-label">Twój adres e-mail</label>
                                    <div class="col-8">
                                        <input type="text" class="form-control" id="inputEmail" placeholder="e-mail">
                                    </div>
                                </div>
                                <div class="form-group row">
                                    <label for="inputPassword" class="col-4 col-form-label">Twoje hasło</label>
                                    <div class="col-8">
                                        <input type="password" class="form-control" id="inputPassword" placeholder="Password">
                                    </div>
                                </div>
                            </form>

                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Anuluj</button>
                            <button type="button" class="btn btn-primary">Zaloguj</button>
                        </div>
                    </div>
                </div>
            </div>




        </ul>
    </div>


</nav>
