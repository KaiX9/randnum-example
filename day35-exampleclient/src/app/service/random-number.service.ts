import { HttpClient, HttpParams } from "@angular/common/http";
import { Injectable, inject } from "@angular/core";
import { Observable, filter, map } from "rxjs";

const URL_API_RANDOM = 'http://localhost:8080/api/random'

@Injectable()
export class RandomNumberService {

    http = inject(HttpClient)

    getRandomNumbers(count = 10): Observable<number[]> {

        const qs = new HttpParams()
            .set('count', count)

        return this.http.get<{ numbers: number[], timestamp: string }>(URL_API_RANDOM, {params: qs})
            .pipe(
                map(resp => resp.numbers)
            )

    }
}