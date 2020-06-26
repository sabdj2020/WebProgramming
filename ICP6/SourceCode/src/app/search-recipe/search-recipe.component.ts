import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-search-recipe',
  templateUrl: './search-recipe.component.html',
  styleUrls: ['./search-recipe.component.css']
})
export class SearchRecipeComponent implements OnInit {
  @ViewChild('recipe') recipes: ElementRef;
  @ViewChild('place') places: ElementRef;
  recipeValue: any;
  placeValue: any;
  venueList = [];
  recipeList = [];

  currentLat: any;
  currentLong: any;
  geolocationPosition: any;

  constructor(private _http: HttpClient) {
  }

  ngOnInit() {

    window.navigator.geolocation.getCurrentPosition(
      position => {
        this.geolocationPosition = position;
        this.currentLat = position.coords.latitude;
        this.currentLong = position.coords.longitude;
      });
  }

  getVenues() {

    this.recipeValue = this.recipes.nativeElement.value;
    this.placeValue = this.places.nativeElement.value;

    if (this.recipeValue !== null) {
      /**
       * Write code to get recipe
       */
      this._http
        .get('https://api.edamam.com/search?q=' + this.recipeValue + '&app_id=56007016&app_key=fb8500c92b2a58c797cd066d240f52bf')
        .subscribe((result: any) => {
          this.recipeList = Object.keys(result.hits).map(keyForHits => {
            const recipe = result.hits[keyForHits].recipe;
            return {
              name: recipe.label, icon: recipe.image, url: recipe.url
            };
          });
        });
    }

    if (this.placeValue != null && this.placeValue !== '' && this.recipeValue != null && this.recipeValue !== '') {
      /**
       * Write code to get place
       */

      this._http
        .get('https://api.foursquare.com/v2/venues/search?client_id=DLLEH4UVGV2XHTNKA4DXRZR205MWC5RNYHDYVTKMV3M5YQY1&client_secret=Y0QZZAOXZZW4COSICUIFLG1OT10WDO4KBIYWP4SORDOM2G2T&v=20200110&limit=8&query=' + this.recipeValue + '&near=' + this.placeValue).
        subscribe(respPlaces => {
          const response = 'response';
          const venues = 'venues';
          this.venueList = respPlaces[response][venues];
        });
    }

  }
}
