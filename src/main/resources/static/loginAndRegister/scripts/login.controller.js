loginController = function () {
    this.search = function () {
        var self = this;
        self.isSearching = true;
        spotifyService.searchArtist(this.query)
            .then(function(artists) {
                self.searchResult = artists;
                self.isSearching = false;
            },function(error) {
                self.isSearching = false;
            })
    };
    this.query;
    this.searchResult;
    this.isSearching = false;
}