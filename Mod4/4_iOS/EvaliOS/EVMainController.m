//
//  EVMainController.m
//  EvaliOS
//
//  Created by Daniel Martin Jimenez on 22/6/15.
//  Copyright (c) 2015 Daniel Martin Jimenez. All rights reserved.
//

#import "EVMainController.h"

@interface EVMainController ()

@property (nonatomic, strong) UITextField *pickerViewTextField;
@property (nonatomic, strong) NSMutableArray *arrayCities;
@property (nonatomic, strong) NSMutableArray *arrayCoord;
@property (nonatomic, strong) NSString *currentCity;

@end

@implementation EVMainController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
    
    [self setItems];
    [self createPicker];
}

-(IBAction)showPicker
{
    NSInteger row = [self.pickerCity selectedRowInComponent:0];
    NSString *city = [self.arrayCities objectAtIndex:row];
    [self.buttonPicker setTitle:city forState:UIControlStateNormal];
    
    [self.pickerViewTextField becomeFirstResponder];
}

-(IBAction)callService
{
    NSMutableString *urlString = [[NSMutableString alloc] initWithString:@"http://api.openweathermap.org/data/2.5/weather?q="];
    [urlString appendString:self.buttonPicker.currentTitle];
    
    NSURL *url = [NSURL URLWithString:urlString];
    NSURLRequest *request = [NSURLRequest requestWithURL:url];
    [NSURLConnection sendAsynchronousRequest:request queue:[NSOperationQueue mainQueue] completionHandler:^(NSURLResponse *response, NSData *data, NSError *connectionError) {
        if(data.length > 0 &&  connectionError == nil){
            NSDictionary *weatherInfo = [NSJSONSerialization JSONObjectWithData:data options:0 error:NULL];
            
            NSNumber *speed = [weatherInfo valueForKeyPath:@"wind.speed"];
            NSNumber *temperatureMax = [weatherInfo valueForKeyPath:@"main.temp_max"];
            NSNumber *temperatureMin = [weatherInfo valueForKeyPath:@"main.temp_min"];
            NSNumber *temperature = [weatherInfo valueForKeyPath:@"main.temp"];
            NSArray *description = [weatherInfo valueForKeyPath:@"weather.description"];
            
            //Crear y setear valores de WeatherAtm
            EVWeatherAtm *weatherAtm = [EVWeatherAtm alloc];
            weatherAtm.speed = speed;
            weatherAtm.temperatureMin = temperatureMin;
            weatherAtm.temperatureMax = temperatureMax;
            weatherAtm.descrip = [description objectAtIndex:0];
            
            //Setear los labels con los valores recogidos de la llamada
            double kelvinTemperature = [temperature doubleValue];
            double celsiusTemperature = kelvinTemperature - 273.15;
            NSString *cadena = [NSString stringWithFormat:@"%f", celsiusTemperature];
            NSArray *characters = [cadena componentsSeparatedByString:@"."];
            NSString *temp = [characters objectAtIndex:0];
            self.labelTemp.text = [temp stringByAppendingString:@" ºC"];
            
            kelvinTemperature = [temperatureMin doubleValue];
            celsiusTemperature = kelvinTemperature - 273.15;
            NSString *cadenaMin = [NSString stringWithFormat:@"%f", celsiusTemperature];
            NSArray *charactersMin = [cadenaMin componentsSeparatedByString:@"."];
            NSString *tempMin = [charactersMin objectAtIndex:0];
            self.labelTempMin.text = [tempMin stringByAppendingString:@" ºC"];
            
            kelvinTemperature = [temperatureMax doubleValue];
            celsiusTemperature = kelvinTemperature - 273.15;
            NSString *cadenaMax = [NSString stringWithFormat:@"%f", celsiusTemperature];
            NSArray *charactersMax = [cadenaMax componentsSeparatedByString:@"."];
            NSString *tempMax = [charactersMax objectAtIndex:0];
            self.labelTempMax.text = [tempMax stringByAppendingString:@" ºC"];
            
            self.labelDesc.text = [description objectAtIndex:0];
            NSString *vel = [speed stringValue];
            self.labelWind.text = [vel stringByAppendingString:@" km/h"];
            
            NSNumber *lat = [weatherInfo valueForKeyPath:@"coord.lat"];
            NSNumber *lon = [weatherInfo valueForKeyPath:@"coord.lon"];
            
            if(lat != nil && lon != nil){
                self.arrayCoord = [[NSMutableArray alloc] init];
                [self.arrayCoord addObject:lat];
                [self.arrayCoord addObject:lon];
            }
            
            self.currentCity = self.buttonPicker.currentTitle;
            [self.buttonMap setHidden:NO];
        }
    }];
}

-(IBAction)openMap
{
    [self performSegueWithIdentifier:@"openMapController" sender:self];
}

-(void)setItems
{
    self.title = @"Principal";
    
    //MODIFICAR EL UIButton
    self.buttonService.layer.borderWidth = 1.5f;
    self.buttonService.layer.cornerRadius = 25;
    self.buttonService.clipsToBounds = YES;
    [self.buttonService setTintColor:[UIColor customColor]];
    self.buttonService.layer.borderColor = [[UIColor customColor]CGColor];
    [self.buttonService setTitle:@"MOSTRAR" forState:UIControlStateNormal];
    
    self.buttonMap.layer.borderWidth = 1.5f;
    self.buttonMap.layer.cornerRadius = 25;
    self.buttonMap.clipsToBounds = YES;
    [self.buttonMap setTintColor:[UIColor customColor]];
    self.buttonMap.layer.borderColor = [[UIColor customColor]CGColor];
    [self.buttonMap setTitle:@"MOSTRAR MAPA" forState:UIControlStateNormal];
    
    [self.buttonService setEnabled:NO];
    [self.buttonMap setHidden:YES];
    
    [self.buttonPicker setTitle:@"seleccione una ciudad..." forState:UIControlStateNormal];
    
    UIView *lineView = [[UIView alloc] initWithFrame:CGRectMake(5, 330, 365, 1)];
    lineView.backgroundColor = [UIColor customColor];
    [self.view addSubview:lineView];
}

//MODIFICA EL COMPORTAMIENTO DEL BOTON CUANDO SE PULSA Y SE DEJA DE PULSAR
-(IBAction) buttonTouchDown:(id)sender
{
    if(sender == self.buttonService){
        self.buttonService.backgroundColor = [UIColor customColor];
        [self.buttonService setTitleColor:[UIColor whiteColor] forState:UIControlStateHighlighted & UIControlStateSelected];
        self.buttonService.layer.borderColor = [UIColor customColor].CGColor;
    } else if(sender == self.buttonMap){
        self.buttonMap.backgroundColor = [UIColor customColor];
        [self.buttonMap setTitleColor:[UIColor whiteColor] forState:UIControlStateHighlighted & UIControlStateSelected];
        self.buttonMap.layer.borderColor = [UIColor customColor].CGColor;
    }
}

-(IBAction) buttonTouchUpOutside:(id)sender
{
    if(sender == self.buttonService){
        self.buttonService.backgroundColor = [UIColor whiteColor];
        [self.buttonService setTitleColor:[UIColor customColor] forState:UIControlStateHighlighted & UIControlStateSelected];
        self.buttonService.layer.borderColor = [UIColor customColor].CGColor;
    } else if(sender == self.buttonMap){
        self.buttonMap.backgroundColor = [UIColor whiteColor];
        [self.buttonMap setTitleColor:[UIColor customColor] forState:UIControlStateHighlighted & UIControlStateSelected];
        self.buttonMap.layer.borderColor = [UIColor customColor].CGColor;
    }
}

-(IBAction) buttonTouchUpInside:(id)sender
{
    if(sender == self.buttonService){
        self.buttonService.backgroundColor = [UIColor whiteColor];
        [self.buttonService setTitleColor:[UIColor customColor] forState:UIControlStateHighlighted & UIControlStateSelected];
        self.buttonService.layer.borderColor = [UIColor customColor].CGColor;
    } else if(sender == self.buttonMap){
        self.buttonMap.backgroundColor = [UIColor whiteColor];
        [self.buttonMap setTitleColor:[UIColor customColor] forState:UIControlStateHighlighted & UIControlStateSelected];
        self.buttonMap.layer.borderColor = [UIColor customColor].CGColor;
    }
}

-(void)createPicker
{
    self.pickerViewTextField = [[UITextField alloc] initWithFrame:CGRectZero];
    [self.view addSubview:self.pickerViewTextField];
    
    self.pickerCity = [[UIPickerView alloc] initWithFrame:CGRectMake(0, 0, 0, 0)];
    self.pickerCity.showsSelectionIndicator = YES;
    self.pickerCity.delegate = self;
    self.pickerCity.dataSource = self;
    
    self.pickerViewTextField.inputView = self.pickerCity;
    
    //Añadir TOOLBAR
    UIToolbar *toolBar = [[UIToolbar alloc] initWithFrame:CGRectMake(0, 0, 320, 44)];
    toolBar.backgroundColor = [UIColor whiteColor];
    
    UIBarButtonItem *doneButton = [[UIBarButtonItem alloc] initWithBarButtonSystemItem:UIBarButtonSystemItemDone target:self action:@selector(doneTouched:)];
    [doneButton setTintColor:[UIColor customColor]];
    UIBarButtonItem *cancelButton = [[UIBarButtonItem alloc] initWithBarButtonSystemItem:UIBarButtonSystemItemCancel target:self action:@selector(cancelTouched:)];
    [cancelButton setTintColor:[UIColor customColor]];
    
    [toolBar setItems:[NSArray arrayWithObjects:cancelButton, [[UIBarButtonItem alloc] initWithBarButtonSystemItem:UIBarButtonSystemItemFlexibleSpace target:nil action:nil], doneButton, nil]];
    self.pickerViewTextField.inputAccessoryView = toolBar;
    
    //Array para el PICKER
    self.arrayCities = [[NSMutableArray alloc] init];
    [self.arrayCities addObject:@"Sevilla,ES"];
    [self.arrayCities addObject:@"Madrid,ES"];
    [self.arrayCities addObject:@"Barcelona,ES"];
    [self.arrayCities addObject:@"London,GB"];
    [self.arrayCities addObject:@"Paris,FR"];
    [self.arrayCities addObject:@"Miami,US"];
    [self.arrayCities addObject:@"Manchester,GB"];
    
}

- (void)cancelTouched:(UIBarButtonItem *)sender
{
    [self.pickerViewTextField resignFirstResponder];
}

- (void)doneTouched:(UIBarButtonItem *)sender
{
    [self.pickerViewTextField resignFirstResponder];
    [self.buttonService setEnabled:YES];
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

-(void)touchesBegan:(NSSet *)touches withEvent:(UIEvent *)event
{
    [self.pickerCity resignFirstResponder];
}

#pragma mark - UIPickerViewDataSource
- (NSInteger)numberOfComponentsInPickerView:(UIPickerView *)pickerView
{
    return 1;
}

- (NSInteger)pickerView:(UIPickerView *)pickerView numberOfRowsInComponent:(NSInteger)component
{
    return self.arrayCities.count;
}

#pragma mark - UIPickerViewDelegate
- (NSString *)pickerView:(UIPickerView *)pickerView titleForRow:(NSInteger)row forComponent:(NSInteger)component
{
    return [self.arrayCities objectAtIndex:row];
}

- (void)pickerView:(UIPickerView *)pickerView didSelectRow:(NSInteger)row inComponent:(NSInteger)component
{
    [self.buttonPicker setTitle:[self.arrayCities objectAtIndex:row] forState:UIControlStateNormal];
}

- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender
{
    if ([[segue identifier] isEqualToString:@"openMapController"])
    {
        EVMapController *destinationController = [segue destinationViewController];
        destinationController.lat = [self.arrayCoord objectAtIndex:0];
        destinationController.lon = [self.arrayCoord objectAtIndex:1];
        destinationController.city = self.currentCity;
    }
}

@end
